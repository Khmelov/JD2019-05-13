package by.it.yaskevich.jd01_11.calc11;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s не возможна ", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s не возможна ", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s не возможна ", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s не возможна ", this, other);
        return null;
    }

    public static Var createVar(String strVar) {
        strVar = strVar.replaceAll("\\s+", "");

        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        else
            return null;
    }

    public static void save(String s, Var two) {
        vars.put(s, two);
    }
}
