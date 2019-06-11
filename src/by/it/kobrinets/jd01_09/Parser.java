package by.it.kobrinets.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression){
        Pattern p = Pattern.compile(Patterns.OPERATION);
        String [] operand = expression.split(p.toString());
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        if (one == null || two == null)
            return null; //TODO create error
        Matcher m = p.matcher(expression);
        if (m.find()){
            switch (m.group()){
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
}
