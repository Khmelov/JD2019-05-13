package by.it.trudnitski.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var) {
        vars.put(name, var);
        return var;
    }

    public static Map<String, Var> getVars() {
        return vars;
    }


    public static Var createVar(String strVar) throws CalcExeption {
        strVar = strVar.trim().replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR)) {
            return new Scalar(strVar);
        } else if (strVar.matches(Patterns.VECTOR)) {
            return new Vector(strVar);
        } else if (strVar.matches(Patterns.MATRIX)) {
            return new Matrix(strVar);
        } else if (vars.containsKey(strVar)) {
            return vars.get(strVar);
        }
        throw new CalcExeption(" Ты пишешь ерунду " + strVar);
    }


    public String toString() {

        return "abstract Var";
    }

    @Override
    public Var add(Var other) throws CalcExeption {
        throw new CalcExeption(String.format(" Операция %s+%s Невозможна%n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcExeption {
        throw new CalcExeption(String.format(" Операция %s-%s Невозможна%n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcExeption {
        throw new CalcExeption(String.format(" Операция %s*%s Невозможна%n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcExeption {
        throw new CalcExeption(String.format(" Операция %s/%s Невозможна%n", this, other));
    }
}
