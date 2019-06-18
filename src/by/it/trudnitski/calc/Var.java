package by.it.trudnitski.calc;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {

    private static Map<String,Var> vars=new HashMap<>();
    static Var saveVar(String name, Var var){
        vars.put(name,var);
        return var;
    }
    public static Map<String,Var> getVars(){
        return vars;
    }


    public static Var createVar(String strVar) {
        strVar=strVar.trim().replaceAll("\\s+", "");
        if(strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if(strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        else if(vars.containsKey(strVar))
            return vars.get(strVar);

        return null;
    }


    public String toString(){

    return "abstract Var";
}

    @Override
    public Var add(Var other) {
        System.out.printf(" Операция %s+%s Невозможна%n", this, other);
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.printf(" Операция %s-%s Невозможна%n", this, other);
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.printf(" Операция %s*%s Невозможна%n", this, other);
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.printf(" Операция %s/%s Невозможна%n", this, other);
        return null;
    }
}
