package by.it.kobrinets.calc11;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) throws CalcException {
        Pattern p = Pattern.compile(Patterns.OPERATION);
        String[] operand = expression.split(p.toString());
        if (operand.length == 1) throw new CalcException("Получена только одна переменная: " + operand[0]);


        Var two = Var.createVar(operand[1]);
        if (expression.contains("=")) {
            return Var.saveVar(operand[0], two);
        }
        Var one = Var.createVar(operand[0]);

        if (one == null || two == null)
            throw new CalcException("ERROR: Вы ничего не ввели");
        Matcher m = p.matcher(expression);
        if (m.find()) {
            switch (m.group()) {
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
        throw new CalcException("ERROR: Ошибка парсинга");
    }
}
