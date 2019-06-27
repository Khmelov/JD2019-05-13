package by.it.izaykoff.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parcer {
    Var calc(String expression){
        String[] operand = expression.split(Var.OPERATION);
        Var one = Var.creatVar(operand[0]);
        Var two = Var.creatVar(operand[1]);
        if (one == null || two == null){
            return null;
        }
        Pattern pattern = Pattern.compile(Var.OPERATION);
        Matcher matcher = pattern.matcher(expression);
        if (matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
