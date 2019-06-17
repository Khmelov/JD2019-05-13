package by.it.adamovichjr.calc;

import java.util.HashMap;
import java.util.Map;

public class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar (String name, Var var){
        vars.put(name, var);
        return var;
    }

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var createVar(String operand){
        operand = operand.trim().replaceAll("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        return null; // NEED create error
    }
    @Override
    public String toString() {
        return "Var";
    }

    @Override
    public Var add(Var other) {
        System.out.println("Оперция + невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Оперция - невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Оперция * невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Оперция / невозможна");
        return null;
    }
}
