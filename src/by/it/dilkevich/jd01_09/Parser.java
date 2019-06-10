package by.it.dilkevich.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {

    String OPERATION = "[-+*/]";
    String SCALAR = "-?[0-9]+\\.?([0-9]+)?";
    String VECTOR = "\\{(-?[0-9]+\\.?([0-9]+)?,?)+\\}";
    String MATRIX = "\\{(\\{(-?[0-9]+\\.?([0-9]+)?,?)+\\},?)+\\}";

    Var calc(String expression){
        String expressions [] = expression.split(OPERATION);
        Pattern pattern = Pattern.compile(OPERATION);
        Matcher matcher = pattern.matcher(expression);

        Var var1;
        Var var2;
        for (String i: expressions) {
            if(i == null)
                return null;
        }

        if (expressions.length == 2){
            var1 = Var.createVar(expressions[0]);
            var2 = Var.createVar(expressions[1]);
            if(matcher.find()){
                switch (matcher.group()){
                    case "+": return var1.add(var2);
                    case "-": return var1.sub(var2);
                    case "*": return var1.mul(var2);
                    case "/": return var1.div(var2);
                }
            }
        }
        return null;
        //// Дописать если выражения более, чем 2
    }
}
