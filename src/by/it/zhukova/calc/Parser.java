package by.it.zhukova.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        expression = expression.replaceAll("\\s+", "");
        String[] part = expression.split(Patterns.OPERATION);
        Var result = null;
        if (part.length == 1) {
            result = Var.createVar(part[0]);
            return result;
        } else if (part.length == 2) {
            Var two = Var.createVar(part[1]);
            Pattern p1 = Pattern.compile(Patterns.OPERATION);
            Matcher m1 = p1.matcher(expression);
            m1.find();
            String operation = m1.group();
            if (operation.equals("=")) {
                String name = part[0];
                Var.save(name, two);
                return two;
            }
            Var one = Var.createVar(part[0]);
            switch (operation) {
                case "+":
                    result = one.add(two);
                    break;
                case "-":
                    result = one.sub(two);
                    break;
                case "/":
                    result = one.div(two);
                    break;
                case "*":
                    result = one.mul(two);
                    break;
            }
        }
        return result;
    }
}
