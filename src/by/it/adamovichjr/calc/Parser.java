package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.text.All_messages;

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
        throw new CalcException(ResourceManager.INSTANCE.get(All_messages.WRONG_OPERATION));
    }



    private Var calcExpressionWithoutBrecket(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
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
            String result = oneOperation(sOne,op,sTwo);
            operands.add(index, result);
        }
        return Var.createVar(operands.get(0));

    }

    Var calc(String expression) throws CalcException{
        StringBuilder result = new StringBuilder(expression);
        StringBuilder buffer = new StringBuilder();
        Pattern patternExpressionWithBracket = Pattern.compile(Patterns.EXPRESSION_IN_BRACKETS);
        Matcher matcher = patternExpressionWithBracket.matcher(result);
        while (matcher.find()){
            buffer.append(matcher.group().replaceAll("[()]",""));
            result.replace(matcher.start(),matcher.end(), calcExpressionWithoutBrecket(buffer.toString()).toString());
            buffer.delete(0,buffer.length());
            matcher.reset();
        }
        return calcExpressionWithoutBrecket(result.toString());
    }
}
