package by.it.tbabich.jd02_05.calc;

import by.it.tbabich.jd02_05.calc.names.Errors;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var other) {
        System.out.printf(Settings.manager.get(Errors.MESSAGE_OPERATION_ERROR), this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf(Settings.manager.get(Errors.MESSAGE_OPERATION_ERROR), this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf(Settings.manager.get(Errors.MESSAGE_OPERATION_ERROR), this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf(Settings.manager.get(Errors.MESSAGE_OPERATION_ERROR), this, other);
        return null;
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
        throw new CalcException(Settings.manager.get(Errors.MESSAGE_ERROR) + strVar);
    }

    static void save(String name, Var var) {
        vars.put(name, var);
    }
}
