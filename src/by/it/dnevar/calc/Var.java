package by.it.dnevar.calc;

import java.util.*;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;
    }

    public static Var createVar(String operand){
        operand = operand.trim().replaceAll("\\s+","");
        if(operand.matches(Operation.SCALAR)){
            return new Scalar(operand);
        }else if(operand.matches(Operation.VECTOR)){
            return new Vector(operand);
        }else if(operand.matches(Operation.MATRIX)){
            return new Matrix(operand);
        }else if(vars.containsKey(operand)) {
            return vars.get(operand);
        } else {
            return  null;
        }
    }

    public static void printVar() {
        for(Map.Entry<String, Var> entry: vars.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    public static void printSortVar() {
        Map<String, Var> sortVars = new TreeMap<>(vars);
        for(Map.Entry<String, Var> entry: vars.entrySet()){
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция "+this+" + "+other+" невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция "+this+" - "+other+" невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция "+this+" * "+other+" невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция "+this+" / "+other+" невозможна");
        return null;
    }

    @Override
    public String toString(){
        return "Этот класс Var";
    }


}
