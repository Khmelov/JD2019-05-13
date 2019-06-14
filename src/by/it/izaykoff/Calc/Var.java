package by.it.izaykoff.Calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars = new HashMap<>();

    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;
    }

    static Var creatVar(String operand){

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
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.printf("Операция %s + %s невозможна%n", this,other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf("Операция %s - %s невозможна%n", this,other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf("Операция %s * %s невозможна%n", this,other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf("Операция %s / %s невозможна%n", this,other);
        return null;
    }

    @Override
    public String toString() {
        return "this is class Var";
    }
}
