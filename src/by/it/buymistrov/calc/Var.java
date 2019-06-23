package by.it.buymistrov.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {


    private static Map<String, Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }


    static Var save(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar(String strVar) {
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        return null;

    }

    @Override
    public String toString() {
        return "abstract 2";
    }


    @Override
    public Var add(Var other) {
        System.out.printf("Операция сложения %s + %s невозможна", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция вычитания  %s - %s невозможна", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция умножения %s * %s невозможна", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция деления %s / %s невозможна", this, other);
        return null;
    }
}
