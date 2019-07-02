package by.it.yaskevich.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    private static final Map<String, Integer> operationsPriorities = new HashMap<>();

    static {
        operationsPriorities.put("=", 0);
        operationsPriorities.put("*", 2);
        operationsPriorities.put("/", 2);
        operationsPriorities.put("+", 1);
        operationsPriorities.put("-", 1);
    }

    private int getIndexOperationWithMaxPriority(List<String> operations) {
        int index = -1;
        int currentPriority = -1;
        for (int i = 0; i < operations.size(); i++) {
            String operation = operations.get(i);
            if (operationsPriorities.get(operation) > currentPriority) {
                currentPriority = operationsPriorities.get(operation);
                index = i;
            }
        }
        return index;
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        expression = calcSimpleExpression(expression);

        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));

        List<String> operations = new ArrayList<>();
        Pattern operationsPattern = Pattern.compile(Patterns.OPERATION);
        Matcher operationsMatcher = operationsPattern.matcher(expression);
        while (operationsMatcher.find()) {
            operations.add(operationsMatcher.group());
        }

        while (operations.size() > 0) {
            int index = getIndexOperationWithMaxPriority(operations);
            String oneOperand = operands.remove(index);
            String twoOperand = operands.remove(index);
            String operation = operations.remove(index);
            String result = oneOperation(oneOperand, operation, twoOperand);
            operands.add(index, result);
        }
        return Var.createVar(operands.get(0));
    }

    private String calcSimpleExpression(String expression) throws CalcException {
        StringBuilder newExpression = new StringBuilder(expression.length());
        boolean brackets = false;
        int bracketsCount = 0;
        int bracketsStart = -1;
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                if (!brackets) {
                    bracketsStart = i;
                }
                brackets = true;
                bracketsCount++;
            } else if (chars[i] == ')') {
                bracketsCount--;
            }
            if (!brackets) {
                newExpression.append(chars[i]);
            }
            if (brackets && (bracketsCount == 0)) {
                newExpression.append(
                        calc(String.valueOf(Arrays.copyOfRange(chars, bracketsStart + 1, i))).toString());
                brackets = false;
            }
        }
        return newExpression.toString();
    }

    private String oneOperation(String oneOperand, String operation, String twoOperand) throws CalcException {
        Var two = Var.createVar(twoOperand);
        if (operation.equals("=")) {
            Var.save(oneOperand, two);
            return two.toString();
        }

        Var one = Var.createVar(oneOperand);
        switch (operation) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "*":
                return one.mul(two).toString();
            case "/":
                return one.div(two).toString();
            default:
                throw new CalcException("ERROR");
        }
    }
}
