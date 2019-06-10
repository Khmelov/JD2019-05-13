package by.it.tbabich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    Var calc(String expression) {
        String[] array = expression.replaceAll(" ", "").split(Patterns.OPERATION);
        Var left = Var.createVar(array[0]);
        Var right = Var.createVar(array[1]);

        Pattern pattern = Pattern.compile(Patterns.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        matcher.find();
        switch (matcher.group()) {
            case Patterns.ADD: return left.add(right);
            case Patterns.SUB: return left.sub(right);
            case Patterns.MUL: return left.mul(right);
            case Patterns.DIV: return left.div(right);
            default: return null;
        }
    }

}
