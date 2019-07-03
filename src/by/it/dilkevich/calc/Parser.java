package by.it.dilkevich.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    String OPERATION = "(?<=[^+=*/{,-])[=*/+-]";
    String SCALAR = "-?[0-9]+\\.?([0-9]+)?";
    String VECTOR = "\\{(-?[0-9]+\\.?([0-9]+)?,?)+\\}";
    String MATRIX = "\\{(\\{(-?[0-9]+\\.?([0-9]+)?,?)+\\},?)+\\}";
    String BRACKETS = "(\\([^(]+?\\))";

    private static final Map<String, Integer> priorMap = new HashMap<>();

    static {
        priorMap.put("=", 0);
        priorMap.put("+", 1);
        priorMap.put("-", 1);
        priorMap.put("*", 2);
        priorMap.put("/", 2);
    }


    Var calc(String expression) throws CalcException {

        Pattern patternBrackets = Pattern.compile(BRACKETS);
        Matcher matcherBrackets = patternBrackets.matcher(expression);
        while (matcherBrackets.find()){
            String matchWithBrackets = matcherBrackets.group();
            int start = matcherBrackets.start();
            int end = matcherBrackets.end();
            String match = matchWithBrackets.replace("(","");
            match = match.replace(")", "");
            String s = calc(match).toString();
            expression = expression.replace(matchWithBrackets,s);
            matcherBrackets = patternBrackets.matcher(expression);
        }

        expression = expression.replaceAll("\\s+", "");
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(OPERATION)));

        List<String> operation = new ArrayList<>();
        Pattern patternOperation = Pattern.compile(OPERATION);
        Matcher matcherOperation = patternOperation.matcher(expression);
        while (matcherOperation.find()) {
            operation.add(matcherOperation.group());
        }

        while (operation.size() > 0) {
            int index = getIndex(operation);
            String sOne = operands.remove(index);
            String sTwo = operands.remove(index);
            String op = operation.remove(index);
            String result = oneOperation(sOne, op, sTwo);
            operands.add(index, result);
        }
        return Var.createVar(operands.get(0));
    }

    private int getIndex(List<String> operation) {
        int index = -1;
        int currentPr = -1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (priorMap.get(op) > currentPr) {
                currentPr = priorMap.get(op);
                index = i;
            }

        }
        return index;
    }


    private String oneOperation(String sOne, String operation, String sTwo) throws CalcException {
        Var two = Var.createVar(sTwo);
        if (operation.equals("=")) {
            Var.saveVar(sOne, two);
            return two.toString();
        }
        Var one = Var.createVar(sOne);
        switch (operation) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
        }
        throw new CalcException("Операция невозможна");
    }
}
