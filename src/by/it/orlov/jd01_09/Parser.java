package by.it.orlov.jd01_09;

import java.util.regex.Pattern;

public class Parser {
    Var calc(String expression){
        Pattern p = Pattern.compile(Patterns.OPERATION);
        String[] operants = (expression.trim()).split(p.toString());
        Var oper1 = Var.createVar(operants[0]);
        Var oper2 = Var.createVar(operants[1]);
        //if(operants)
    return new Scalar(-111);
    }
}
