package by.it.buymistrov.calc;

import by.it.buymistrov.calc.names.Messages;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {


    private static Map<String, Var> vars = new HashMap<>();

    static Map<String, Var> getVars() {
        return vars;
    }


    static Var save(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    static Var createVar(String strVar) throws CalcException {
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
        throw new CalcException(ResManager.INSTANCE.get(Messages.IDUWII) +strVar);

    }

    @Override
    public String toString() {
        return "abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format(ResManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE), this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format(ResManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE), this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format(ResManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE), this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format(ResManager.INSTANCE.get(Messages.OPERATIONIMPOSSIBLE), this, other));
    }
}
