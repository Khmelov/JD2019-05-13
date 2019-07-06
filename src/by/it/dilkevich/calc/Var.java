package by.it.dilkevich.calc;

import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return "it's abstract class";
    }

    @Override
    public Var add(Var other) throws CalcException {

        throw new CalcException(ResManager.getName("operaton.add") + this + " + " + other + ResManager.getName("operation.notpossible"));
    }

    @Override
    public Var sub(Var other) throws CalcException {

        throw new CalcException(ResManager.getName("operaton.sub") + this + " - " + other + ResManager.getName("operation.notpossible"));
    }

    @Override
    public Var mul(Var other) throws CalcException {

        throw new CalcException(ResManager.getName("operaton.mul") + this + " * " + other + ResManager.getName("operation.notpossible"));
    }

    @Override
    public Var div(Var other) throws CalcException {

        throw new CalcException(ResManager.getName("operaton.div") + this + " / " + other + ResManager.getName("operation.notpossible"));
    }

    private static Map<String, Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar(String name, Var var){

        vars.put(name, var);
        return  var;
    }

    static Var createVar(String statement) throws CalcException {

        statement = statement.replaceAll(" ", "");
        Parser parser = new Parser();

        if (statement.matches(parser.SCALAR)){
            Var var = new Scalar(statement);
            return var;
        }
        else if (statement.matches(parser.VECTOR)){
            Var var = new Vector(statement);
            return var;
        }
        else if (statement.matches(parser.MATRIX)){
            Var var = new Matrix(statement);
            return var;
        } else if (vars.containsKey(statement)) {

            return vars.get(statement);
        }

        throw new CalcException(ResManager.getName("error.create") + statement);
    }

}
