package by.it.tbabich.calc;

import by.it.tbabich.calc.factory.CreatorMatrix;
import by.it.tbabich.calc.factory.CreatorScalar;
import by.it.tbabich.calc.factory.CreatorVector;
import by.it.tbabich.calc.names.Errors;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    @Override
    public Var add(Var other) throws CalcException {
        String message = String.format(Settings.manager.get(Errors.MESSAGE_OPERATION_ADD_ERROR), this, other);
        throw new CalcException(message);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        String message = String.format(Settings.manager.get(Errors.MESSAGE_OPERATION_SUB_ERROR), this, other);
        throw new CalcException(message);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        String message = String.format(Settings.manager.get(Errors.MESSAGE_OPERATION_MUL_ERROR), this, other);
        throw new CalcException(message);
    }

    @Override
    public Var div(Var other) throws CalcException {
        String message = String.format(Settings.manager.get(Errors.MESSAGE_OPERATION_DIV_ERROR), this, other);
        throw new CalcException(message);
    }

    static Var createVar(String strVar) throws CalcException {
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR))
            return new CreatorScalar().factoryMethod(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new CreatorVector().factoryMethod(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new CreatorMatrix().factoryMethod(strVar);
        else if (vars.containsKey(strVar))
            return vars.get(strVar);
        throw new CalcException(Settings.manager.get(Errors.MESSAGE_ERROR) + strVar);
    }

    static void save(String name, Var var) {
        vars.put(name, var);
    }

    static void printvar() {
        Set<Map.Entry<String, Var>> entries = vars.entrySet();
        for (Map.Entry<String, Var> element : entries) {
            System.out.print(element.getKey() + "=");
            System.out.println(element.getValue());
        }
    }

    static void sortvar() {
        Map<String, Var> sortVars = new TreeMap<>(vars);
        Set<Map.Entry<String, Var>> entries = sortVars.entrySet();
        for (Map.Entry<String, Var> element : entries) {
            System.out.print(element.getKey() + "=");
            System.out.println(element.getValue());
        }
    }
}
