package by.it.zhukova.calc;

import by.it.zhukova.calc.exceptions.Exceptions;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static by.it.zhukova.calc.ConsoleRunner.*;

public class Parser {
    private static final Map<String,Integer> priorityOperation= new HashMap<>();
    static {
        priorityOperation.put("=", 0 );
        priorityOperation.put("-", 1 );
        priorityOperation.put("+", 1 );
        priorityOperation.put("*", 2 );
        priorityOperation.put("/", 2 );
    }
    private int getIndex (List<String> operation) {
        int index = -1;
        int currentPr = -1;
        for (int i = 0; i < operation.size(); i++) {
            String op = operation.get(i);
            if (priorityOperation.get(op)>currentPr){
                currentPr = priorityOperation.get(op);
                index=i;
            }
        }
        return index;
    }

    Var calc(String expression) throws Exception {
        expression = expression.replaceAll("\\s+", "");
        Pattern patternBkt = Pattern.compile(Patterns.BKT);
        Matcher matcherBkt = patternBkt.matcher(expression);
        String result = null;
        if (matcherBkt.find()){
            String exp = matcherBkt.group();
            String expClear=exp.replaceAll("[()]","");
            String res = calc(expClear).toString();
            int start = matcherBkt.start();
            int end = matcherBkt.end();
            String expressionPart2;
            expressionPart2 = expression.substring(end);
            expression = expression.substring(0, start);
            expression = expression.concat(res).concat(expressionPart2);
            result = calc (expression).toString();
        }
       else {
            List<String> operation = new ArrayList<>();
            Pattern patternOperands = Pattern.compile(Patterns.OPERATION);
            Matcher matcherOperands = patternOperands.matcher(expression);
            while (matcherOperands.find()) {
                operation.add(matcherOperands.group());
            }
            List<String> operands = new ArrayList<>(Arrays.asList(expression.split(Patterns.OPERATION)));
            while (operation.size() > 0) {
                int index = getIndex(operation);
                String One = operands.remove(index);
                String Two = operands.remove(index);
                String op = operation.remove(index);
                String oneresult = oneOperationCalc(One, op, Two);
                operands.add(index, oneresult);
            }
            result=operands.get(0);
        }
       return Var.createVar(result);
    }

    private String oneOperationCalc (String sOne,String operation, String sTwo) throws CalcException {
        Var two = Var.createVar(sTwo);
        if (operation.equals("=")) {
            String name = sOne;
            Var.save(name, two);
            return sTwo;
        }
        Var one = Var.createVar(sOne);
        switch (operation) {
            case "+":
                return one.add(two).toString();
            case "-":
                return one.sub(two).toString();
            case "/":
                return one.div(two).toString();
            case "*":
                return one.mul(two).toString();
        }
        throw new CalcException(manager.get(Exceptions.ERRORTOTAL));
    }
}
