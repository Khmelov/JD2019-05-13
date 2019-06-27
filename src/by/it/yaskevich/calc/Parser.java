package by.it.yaskevich.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression) throws CalcException {
        expression = expression.replaceAll("\\s+", "");
        String[] part = expression.split(Patterns.OPERATION);
        Var result = null;
        if (part.length == 1) {
            if (part[0].equals(Patterns.PRINTVAR))
                Var.printVar();
            else if (part[0].equals(Patterns.SORTVAR))
                Var.sortVar();
            else
                Var.createVar(part[0]);
        } else if (part.length == 2) {
            Var two = Var.createVar(part[1]);
            Pattern pattern = Pattern.compile(Patterns.OPERATION);
            Matcher matcher = pattern.matcher(expression);

            matcher.find();
            String operation = matcher.group();
            if (operation.equals("=")) {
                Var.save(part[0], two);
                return two;
            }
            Var one = Var.createVar(part[0]);

            switch (operation) {
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return result;
    }
}
