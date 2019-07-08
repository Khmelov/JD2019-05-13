package by.it.izaykoff.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Pattern;

abstract class Var implements Operation, Patterns {

    private static Map<String,Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;
    }

    public static Map<String, Var> getVars() {
        return vars;
    }

//    public static void printVar() {
//        for(Map.Entry<String, Var> entry: vars.entrySet()){
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }
//    }
//
//    public static void printSortVar() {
//        for(Map.Entry<String, Var> entry: vars.entrySet()){
//            System.out.println(entry.getKey()+"="+entry.getValue());
//        }
//    }


    static Var createVar(String operand) throws CalcException {

        operand = operand.trim().replaceAll("\\s","");
        if (operand.matches(Var.SCALAR)){
            return new Scalar(operand);
        }
        if (operand.matches(Var.VECTOR)){
            return new Vector(operand);
        }
        if (operand.matches(Var.MATRIX)){
            return new Matrix(operand);
        }
        if(vars.containsKey(operand)){
            return vars.get(operand);
        }
        throw  new CalcException("Невозможно создать " + operand);
    }

    @Override
    public Var add(Var other) throws CalcException{
        throw new CalcException("Операция %s - %s невозможна%n", this,other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException("Операция %s - %s невозможна%n", this,other);
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция %s - %s невозможна%n", this,other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция %s - %s невозможна%n", this,other);
    }

    @Override
    public String toString() {
        return "this is class Var";
    }
}
