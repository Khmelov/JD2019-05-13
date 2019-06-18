package by.it.akhmelev.calc13;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {

    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        String[] part = expression.split(Patterns.OPERATION);
        Var result = null;
        if (part.length == 1) {
            result = Var.createVar(part[0]);
        } else if (part.length == 2) {
            Var two = Var.createVar(part[1]);
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);

            matcher.find();
            String operation = matcher.group();
            if (operation.equals("=")) {
                String name=part[0];
                Var.save(name, two);
                return two;
            }

            Var one = Var.createVar(part[0]);
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
        //error

        return result;
    }
}
