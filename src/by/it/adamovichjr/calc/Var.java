package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.text.All_messages;

import java.util.HashMap;
import java.util.Map;

public class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static void save(String name, Var var) {
        vars.put(name, var);
    }

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replaceAll("\\s+","");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if(operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        if (operand.matches(Patterns.MATRIX))
            return new Matrix(operand);
        else if (vars.containsKey(operand))
            return vars.get(operand);
        throw new CalcException(ResourceManager.INSTANCE.get(All_messages.ERROR) + operand);
    }
    @Override
    public String toString() {
        return "Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(ResourceManager.INSTANCE.get(All_messages.OPERATION_ADD), this, other));

    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(ResourceManager.INSTANCE.get(All_messages.OPERATION_SUB), this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(ResourceManager.INSTANCE.get(All_messages.OPERATION_MUL), this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(ResourceManager.INSTANCE.get(All_messages.OPERATION_DIV), this, other));
    }
}
