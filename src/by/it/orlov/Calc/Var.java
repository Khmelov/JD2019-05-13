package by.it.orlov.Calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    static Var createVar(String oper) {
        oper = oper.trim().replaceAll("\\s+","");
        if (oper.matches(Patterns.SCALAR))
            return new Scalar(oper);
        if(oper.matches(Patterns.VECTOR))
            return new Vector(oper);
        if (oper.matches(Patterns.MATRIX))
            return new Matrix(oper);
        else if (vars.containsKey(oper))
            return vars.get(oper);
        return null;
    }
    private static Map<String, Var> vars = new HashMap<>();
    public static Map<String, Var> getVars() {
        return vars;
    }
    static Var saveVar (String name, Var var){
        vars.put(name, var);
        return var;
    }
    @Override
    public Var add(Var other) {
        System.out.println("Невозможно"+other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Невозможно"+other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Невозможно"+other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Невозможно"+other);
        return null;
    }

    @Override
    public String toString() {
        return "abstract Var";
    }

}
