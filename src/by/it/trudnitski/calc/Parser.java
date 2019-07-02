package by.it.trudnitski.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    private static Map<String, Integer> priorMap = new HashMap<>();

    static {
        priorMap.put("=", 0);
        priorMap.put("+", 1);
        priorMap.put("-", 1);
        priorMap.put("*", 2);
        priorMap.put("/", 2);
    }


    private String oneOperations(String sOne, String operation, String sTwo) throws CalcExeption {
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
        throw new CalcExeption("ERROR!!!!!!!!!");
    }

    Var calc(String expression) throws CalcExeption {
        expression = expression.replaceAll("\\s+", "");
        expression = newCalc(expression);
        List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
        List<String> operations = new ArrayList<>();
        Pattern patternOperations = Pattern.compile(Patterns.OPERATION);
        Matcher matcherOperations = patternOperations.matcher(expression);
        while (matcherOperations.find()) {
            operations.add(matcherOperations.group());
        }

        while (operations.size() > 0) {
            int index = getIndex(operations);
            String sOne = operands.remove(index);
            String sTwo = operands.remove(index);
            String op = operations.remove(index);
            String result = oneOperations(sOne, op, sTwo);
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

    private String newCalc(String expression) throws CalcExeption {
        boolean flag = false;
        int start = -1;
        int end = 0;
        StringBuilder expressionNew = new StringBuilder(expression.length());
        char[] chars = expression.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '(') {
                if (!flag) {
                    start = i;
                }
                flag = true;
                end++;
            } else if (chars[i] == ')') {
                end--;
            }
            if (!flag) {
                expressionNew.append(chars[i]);
            }
            if (flag && (end == 0)) {
                expressionNew.append(calc(String.valueOf(Arrays.copyOfRange(chars, start + 1, i))).toString());
            }
        }
        return expressionNew.toString();
    }
}
