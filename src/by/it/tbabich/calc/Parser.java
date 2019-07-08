package by.it.tbabich.calc;

import by.it.tbabich.calc.names.Errors;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {



    private static final Map<String, Integer> priorMap = new HashMap<>();

    static {
        priorMap.put("=", 0);
        priorMap.put("+", 1);
        priorMap.put("-", 1);
        priorMap.put("*", 2);
        priorMap.put("/", 2);
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
            Var.save(sOne, two);
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
        throw new CalcException(Settings.manager.get(Errors.MESSAGE_ERROR));
    }


    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        StringBuilder sb = new StringBuilder(expression);
        Pattern pattern = Pattern.compile(Patterns.HOOKS);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()){
            String tempExpression = matcher.group();
            int startIndex = sb.indexOf(tempExpression);
            int endIndex = startIndex + tempExpression.length();
            sb.replace(startIndex, endIndex, calc(tempExpression.replaceAll("\\(", "").replaceAll("\\)", "")).toString());
            matcher.reset();
        }
        expression = sb.toString();
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operation = new ArrayList<>();
        Pattern patternOperation = Pattern.compile(Patterns.OPERATION);
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

}
