package by.it.izaykoff.calc;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {

    private static final Map<String, Integer> priorMap = new HashMap<>();

    static {
        priorMap.put("=", 0);
        priorMap.put("+", 1);
        priorMap.put("-", 1);
        priorMap.put("*", 2);
        priorMap.put("/", 2);
        priorMap.put("(", 3);
        priorMap.put(")", 3);
    }

    private int getIndex(List<String> operation) {
        int index = -1, currentPr = -1;
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
        throw new CalcException("Неправельный операнд");
    }

    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll("[,\\]\\[]","").replaceAll("\\s+","");
        List<String> list = new CopyOnWriteArrayList<>();


        if (expression.contains("(")){
            list = new ArrayList<>(Arrays.asList(expression.split("(?<=\\G.)")));
//            StringTokenizer strTok = new StringTokenizer(expression, "-+*/()=", true);
//            while (strTok.hasMoreTokens()) {
//                list.add(strTok.nextToken());
//            }
        }
        while (expression.contains("(")){
            List<String> temp = new CopyOnWriteArrayList<>();
            int first = 0;
            int last = 0;
            int listSize = 0;

            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).equals("(")) {
                    first = i;
                }
                if (list.get(i).equals(")") && last < i) {
                    last = i;
                    listSize = last - first;
                    temp.addAll(list.subList(first + 1, last));
                    break;
                }
            }

            String res = calc(temp.toString()).toString();
            for (int i1 = 0; i1 <= listSize; i1++) {
                list.remove(first);
            }
            list.add(first, res);
            StringBuilder newExpression = new StringBuilder();
            for (String s : list) {
                newExpression.append(s);
            }
            expression = newExpression.toString();
            temp.clear();

        }


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
