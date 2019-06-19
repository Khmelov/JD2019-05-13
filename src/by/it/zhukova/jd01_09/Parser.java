package by.it.zhukova.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression) {
        String[] part = expression.split(Patterns.OPERATION);
        if (part.length == 1) {
            Var result = Var.createVar(part[0]);
            return result;}
        else if (part.length == 2) {
            Var one = Var.createVar(part[0]);
            Var two = Var.createVar(part[1]);
            Pattern p1 = Pattern.compile(Patterns.OPERATION);
            Matcher m1 =p1.matcher(expression);
            if ( m1.find()){
                String operation = m1.group();
                Var result = null;
            switch (operation){
                case "+":  result = one.add(two); break;
                case "-":  result = one.sub(two); break;
                case "/":  result = one.div(two); break;
                case "*":  result = one.mul(two); break;
                default:break;
            }
                return result;
            }
            return null;}
        else return null;
    }
}
