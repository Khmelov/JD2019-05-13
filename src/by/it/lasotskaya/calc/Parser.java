package by.it.lasotskaya.calc;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    List<String> operations;
    List<String> operands;

    private static final Map<String, Integer> priorMap = new HashMap<>();

    static {
        priorMap.put("=", 0);
        priorMap.put("+", 1);
        priorMap.put("-", 1);
        priorMap.put("*", 2);
        priorMap.put("/", 2);
    }

    private int getIndex() {
        int index = -1;
        int currentPr = -1;
        for (int i = 0; i < operations.size(); i++) {
            String op = operations.get(i);
            if (priorMap.get(op) > currentPr) {
                currentPr = priorMap.get(op);
                index = i;
            }

        }
        return index;
    }
    private String oneOperation(String sOne, String operation, String sTwo) throws CalcException {
        Var two = Var.createVar(sTwo);
        if (operation.equals("=")&& sOne.matches(Patterns.VARNAME)) {
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
        throw new CalcException("Error !!!!!");
    }
    Var calc(String expression)throws CalcException{
        Pattern parentheses = Pattern.compile("(\\()([^\\(\\)]*)(\\))");
        Matcher mp= parentheses.matcher(expression);
        while (mp.find()){
            expression=expression.replaceFirst("(\\()([^\\(\\)]*)(\\))",calc(mp.group(2)).toString());
            mp.reset(expression);
        }
        operands = new ArrayList<>(
                Arrays.asList(expression.split(Patterns.OPERATION))
        );
        operations = new ArrayList<>();
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        while (m.find()) {
            operations.add(m.group());
        }
        while (operations.size() > 0) {
            int index = getIndex();
            String op = operations.remove(index);
            String oLeft = operands.get(index);
            String oRight = operands.remove(index + 1);
            operands.set(index, oneOperation(oLeft, op, oRight).toString());
        }
        return Var.createVar(operands.get(0));
    }
   }
