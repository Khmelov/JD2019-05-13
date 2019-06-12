package by.it.adamovichjr.jd01_08_v2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        String[] operand = expression.split(Patterns.OPERATION);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        String typeOne = createType(operand[0]);
        String typeTwo = createType(operand[1]);
        one.
        switch (typeOne){
            case "Scalar":
                one = (Scalar)one;
            case "Vector":
                Vector ones = (Vector)one;
        }

        if (one == null || two == null)
            return null; // NEED error
        Pattern oper = Pattern.compile(Patterns.OPERATION);
        Matcher m = oper.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation) {
                case "+":
                    return one.add(two);
                case "-":
                    return one.sub(two);
                case "*":
                    return one.mul(two);
                case "/":
                    return one.div(two);
            }
        }
        return null;
    }

    static String createType(String operand){
        operand = operand.trim().replaceAll("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return "Scalar";
        if(operand.matches(Patterns.VECTOR))
            return "Vector";
        if (operand.matches(Patterns.MATRIX))
            return "Matrix";
        return null; // NEED create error
    }
}