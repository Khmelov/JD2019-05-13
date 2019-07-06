package by.it.adamovichjr.jd01_09_v2;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Parser {
    Var calc(String expression) {
        String[] operand = expression.split(Patterns.OPERATION);


        Pattern oper = Pattern.compile(Patterns.OPERATION);
        Matcher m = oper.matcher(expression);
        if (m.find()) {
            String operation = m.group();
            switch (operation) {
                case "+":
                    return Var.createVar(operand[0]).add(Var.createVar(operand[1]));
                case "-":
                    return Var.createVar(operand[0]).sub(Var.createVar(operand[1]));
                case "*":
                    return Var.createVar(operand[0]).mul(Var.createVar(operand[1]));
                case "/":
                    return Var.createVar(operand[0]).div(Var.createVar(operand[1]));

            }
        }
        return null;
    }


}
