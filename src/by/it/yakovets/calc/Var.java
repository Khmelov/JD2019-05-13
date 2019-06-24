package by.it.yakovets.calc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {

    static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;

    }


    public static Var createVar(String strVar) throws CalcException{
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (vars.containsKey(strVar))
            return vars.get(strVar);

        throw new CalcException("Невозможно создать "+strVar);
    }

    @Override
    public String toString() {
        return "abstract2";
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения "+this+"+"+other+" невозможна");

    }

    @Override
    public Var sub(Var other) throws CalcException{
        throw new CalcException("Операция вычитания "+this+"-"+other+" невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения "+this+"*"+other+" невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException{
        throw new CalcException("Операция деления "+this+"/"+other+" невозможна");
    }
}

