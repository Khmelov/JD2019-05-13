package by.it.dilkevich.calc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public abstract class Var implements Operation {

    @Override
    public String toString() {
        return "it's abstract class";
    }

    @Override
    public Var add(Var other) throws CalcException, IOException {

        Logger.setLog(ResManager.getName("operation.add") + this + " + " + other + ResManager.getName("operation.notpossible"));
        throw new CalcException(ResManager.getName("operation.add") + this + " + " + other + ResManager.getName("operation.notpossible"));
    }

    @Override
    public Var sub(Var other) throws CalcException, IOException {

        Logger.setLog(ResManager.getName("operation.sub") + this + " + " + other + ResManager.getName("operation.notpossible"));
        throw new CalcException(ResManager.getName("operation.sub") + this + " - " + other + ResManager.getName("operation.notpossible"));
    }

    @Override
    public Var mul(Var other) throws CalcException, IOException {

        Logger.setLog(ResManager.getName("operation.mul") + this + " + " + other + ResManager.getName("operation.notpossible"));
        throw new CalcException(ResManager.getName("operation.mul") + this + " * " + other + ResManager.getName("operation.notpossible"));
    }

    @Override
    public Var div(Var other) throws CalcException, IOException {

        Logger.setLog(ResManager.getName("operation.div") + this + " + " + other + ResManager.getName("operation.notpossible"));
        throw new CalcException((ResManager.getName("operation.div") + this + " / " + other + ResManager.getName("operation.notpossible")));
    }

    private static Map<String, Var> vars = new HashMap<>();

    public static Map<String, Var> getVars() {
        return vars;
    }

    static Var saveVar(String name, Var var){

        vars.put(name, var);
        return  var;
    }

    static Var createVar(String statement) throws CalcException, IOException {

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

        Logger.setLog(ResManager.getName("error.create"));
        throw new CalcException(ResManager.getName("error.create") + statement);
    }

}
