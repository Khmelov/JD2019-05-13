package by.it.kobrinets.calc11;

import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name, var);
        return var;
    }
    static void printvar (){
        Set<Map.Entry<String, Var>> entrySet = vars.entrySet();
        for (Map.Entry<String, Var> varEntry : entrySet) {
            System.out.println(varEntry.getKey() + "=" + varEntry.getValue());
        }
    }

    static void sortvar () {
        Map<String,Var> sortV = new TreeMap<String,Var>(vars);
        System.out.println(sortV);
    }



    static Var createVar(String operand) throws CalcException {
        operand = operand.trim().replace("\\s+", "");
        if (operand.matches(Patterns.SCALAR))
            return new Scalar(operand);
        if (operand.matches(Patterns.VECTOR))
            return new Vector(operand);
        //if (operand.matches(Patterns.MATRIX))
        //    return new Matrix(operand);
        if (vars.containsKey(operand))
            return vars.get(operand);
        throw  new CalcException("Невозможно создать " + operand);
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + " + "+ other + "невоможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция вычитания " + this + " - " + other + "невоможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + " * "+ other + "невоможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + " / "+ other + "невоможна");
    }
}