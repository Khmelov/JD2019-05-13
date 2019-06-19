package by.it.lasotskaya.calc;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression){

        Pattern p=Pattern.compile (Patterns.OPERATION);
        Matcher m=p.matcher(expression);
        if (m.find()) {
            String[] strOp=expression.split(Patterns.OPERATION);
            Var one= Var.createVar(strOp[0]);
            Var two= Var.createVar(strOp[1]);

            if (expression.contains("=")){
                Var.saveVar(strOp[0],two);
            }
            String operation=m.group();
            switch (operation){
                case "+":return one.add(two);
                case "-":return one.sub(two);
                case "*":return one.mul(two);
                case "/":return one.div(two);
                default:
                    throw new IllegalStateException("Unexpected value: " + operation);
            }
        }
        return null;
    }
}