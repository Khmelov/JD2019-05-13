package by.it.aadamovich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) {
        String[] operands = expression
                .replaceAll(" ", "")
                .split(Patterns.OPERATION);
        Var operand1 = Var.createVar(operands[0]);
        Var operand2 = Var.createVar(operands[1]);
        Pattern p = Pattern.compile(Patterns.OPERATION);
        Matcher m = p.matcher(expression);
        if (m.find()) {
            switch (m.group()) {
                case "+":
                    return operand1.add(operand2);
                case "-":
                    return operand1.sub(operand2);
                case "*":
                    return operand1.mul(operand2);
                case "/":
                    return operand1.div(operand2);
            }
        }
                return null;
    }
}
