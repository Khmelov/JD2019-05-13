package by.it.aadamovich.calc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static HashMap<String, Integer> priority = new HashMap<>();

    static {
        priority.put("=", 0);
        priority.put("+", 1);
        priority.put("-", 1);
        priority.put("*", 2);
        priority.put("/", 2);
    }

    private static int getIndex(List<String> operations) {
        int index = -1;
        int priorityCurrent = -1;
        String operation;
        for (int i = 0; i < operations.size(); i++) {
            operation = operations.get(i);
            if (priority.get(operation) > priorityCurrent) {
                priorityCurrent = priority.get(operation);
                index = i;
            }
        }
        return index;
    }

    private static String singleCalculation(String one, String operation, String two) throws CalcException {

        Var varTwo = Var.createVar(two);

        if (operation.matches("=")) {
            VarList.setVariable(one, varTwo);
            return varTwo.toString();
        }
        Var varOne = Var.createVar(one);

        switch (operation) {
            case "+":
                return varOne.add(varTwo).toString();
            case "-":
                return varOne.sub(varTwo).toString();
            case "*":
                return varOne.mul(varTwo).toString();
            case "/":
                return varOne.div(varTwo).toString();
        }
        throw new CalcException("Операция невозможна");
    }

    Var calc(String expression) throws CalcException {

        expression = expression.replaceAll("\\s+", "");
        while (expression.contains("(")) {
            Pattern patBracket = Pattern.compile(Patterns.BRACKET);
            Matcher matcherBracket = patBracket.matcher(expression);
            if (matcherBracket.find()) {
                String insideBrackets = matcherBracket.group().replaceAll("[()]", "");
                expression = expression
                        .replaceFirst(Patterns.BRACKET, calc(insideBrackets).toString())
                        .replaceAll("\\s+", "");
            } else {
                throw new CalcException("Скобки расставлены неверно");
            }
        }
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));

        if (operands.size() == 1) throw new CalcException("Получена только одна переменная: " + operands.get(0));

        List<String> operations = new ArrayList<>();
        Pattern patOperation = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperation = patOperation.matcher(expression);
        while (matcherOperation.find()) {
            operations.add(matcherOperation.group());
        }

        while (operations.size() > 0) {
            int index = getIndex(operations);
            String operation = operations.remove(index);
            String one = operands.remove(index);
            String two = operands.remove(index);
            String resultOperand = singleCalculation(one, operation, two);
            operands.add(index, resultOperand);
        }
        return Var.createVar(operands.get(0));
    }
}
