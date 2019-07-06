package by.it.maniuk.calc;

import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    private static final Map<String, Integer> priorMap = new HashMap<>();

    static {
        priorMap.put("=", 0);
        priorMap.put("+", 1);
        priorMap.put("-", 1);
        priorMap.put("*", 2);
        priorMap.put("/", 2);
    }

    private int getIndex(List<String> operation) {
        int index = - 1;
        int currentPr = - 1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (priorMap.get(op) > currentPr) {
                currentPr = priorMap.get(op);
                index = i;
            }
            ;
        }
        return index;
    }


    private String oneOperaion(String sOne, String operation, String sTwo) throws CalcException, IOException {
        Var two = Var.createVar(sTwo);
        if (operation.equals("=")) {
            String name = sOne;
            Var.saveVar(name, two);
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
        throw new CalcException("Error !!!!!");
    }

    Var calc(String expression) throws CalcException, IOException {
        Var var = null;
        String[] s;
        if (expression.contains("(") && expression.contains(")")) {
            while (expression.contains("(")){
            s = getString(expression);
            Var res= calcRev(s[0]);
           expression = expression.replace(s[1],res.toString());
            }

        } else {
           var = calcRev(expression); // не убирать пока что
        }
        return var = calcRev(expression);
    }

    private String[] getString(String s) {
        String del = null;
        String[] array;
        Pattern p = Pattern.compile("\\([^()]+\\)");
            Matcher m = p.matcher(s);
           if (m.find()){
             del = (String) m.group();
             s = del.replaceAll("\\(", "");
             s = s.replaceAll("\\)", "");
           }
        array = new String[]{s,del};
        return  array;
    }

    Var calcRev (String expression) throws CalcException, IOException {
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
            String result = oneOperaion(sOne, op, sTwo);
            operands.add(index, result);
        }

       return Var.createVar(operands.get(0));

    }
}