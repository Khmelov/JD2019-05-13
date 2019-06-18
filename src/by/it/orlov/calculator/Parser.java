package by.it.orlov.calculator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Parser {
    Var calc(String expression){

        String[] operand = expression.split(Patterns.OPERATION);
        Var two = Var.createVar(operand[1]);
        if(expression.contains("=")){
            return Var.saveVar(operand[0],two);
        }
        Var one = Var.createVar(operand[0]);
        if (one == null || two == null)
            return null; // NEED error
        Pattern oper = Pattern.compile(Patterns.OPERATION);
        Matcher m = oper.matcher(expression);
        if(m.find()){
            String operation = m.group();
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
