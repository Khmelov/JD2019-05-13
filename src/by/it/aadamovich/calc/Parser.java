package by.it.aadamovich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException{
        String[] stringOperands = expression
                .replaceAll("\\s+", "")
                .split(Patterns.OPERATION);
        if (stringOperands.length==1) throw new CalcException("Получена только одна переменная: " + stringOperands[0]);

        Var varOperand2 = Var.createVar(stringOperands[1]);

        if (expression.contains("=")) {
            return VarList.setVariable(stringOperands[0], varOperand2);
        } else {
            Var varOperand1 = Var.createVar(stringOperands[0]);
            Pattern p = Pattern.compile(Patterns.OPERATION);
            Matcher m = p.matcher(expression);
            if (m.find()) {
                switch (m.group()) {
                    case "+":
                        return varOperand1.add(varOperand2);
                    case "-":
                        return varOperand1.sub(varOperand2);
                    case "*":
                        return varOperand1.mul(varOperand2);
                    case "/":
                        return varOperand1.div(varOperand2);
                }
            }
            // to do some error
        }
        return null;
    }
}
