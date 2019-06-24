package by.it.yaskevich.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public abstract class Var implements Operation {
    private static Map<String, Var> vars = new HashMap<>();

    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + " + " + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания" + this + " - " + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " * " + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " / " + other + " невозможна");
    }

    public static Var createVar(String strVar) throws CalcException {
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
            throw new CalcException("Невозможно создать " + strVar);
    }

    public static void printVar() {
        if (!vars.isEmpty()) {
            for (Map.Entry<String, Var> varEntry : vars.entrySet()) {
                System.out.printf("%s=%s\n", varEntry.getKey(), varEntry.getValue());
            }
        }
    }

    public static void save(String s, Var two) {
        vars.put(s, two);
    }

    public static void sortVar() {
        if (!vars.isEmpty()) {
            Map<String, Var> dictionary = new TreeMap<>(vars);
            for (Map.Entry<String, Var> varEntry : dictionary.entrySet()) {
                System.out.printf("%s=%s\n", varEntry.getKey(), varEntry.getValue());
            }
        }
    }
}
