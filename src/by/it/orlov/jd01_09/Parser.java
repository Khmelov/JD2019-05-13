package by.it.orlov.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression){
        Pattern p = Pattern.compile(Patterns.OPERATION);
        String[] operants = (expression.trim()).split(p.toString());
        Var oper1 = Var.createVar(operants[0]);
        Var oper2 = Var.createVar(operants[1]);
        if(oper1==null||oper2==null)return null;
        Matcher matcher = p.matcher(expression);
        if (matcher.find()){
            switch (matcher.group()){
                case "+":
                    return oper1.add(oper2);
                case "-":
                    return oper1.sub(oper2);
                case "*":
                    return oper1.mul(oper2);
                case "/":
                    return oper1.div(oper2);
            }
        }
    return null;
    }
}
