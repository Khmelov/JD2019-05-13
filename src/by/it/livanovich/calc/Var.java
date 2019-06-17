package by.it.livanovich.calc;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

abstract class Var implements Operation {

    private static Map <String,Var> varMap=new HashMap<>();

    static Var saveVar (String name, Var var){
        varMap.put(name,var);
        return var;
    }

    static void print (){
        for (Map.Entry<String, Var> entry : varMap.entrySet()) {
            String key = entry.getKey().toString();
            String value = entry.getValue().toString();
            System.out.printf("%s = %s\n", key, value);
        }
    }
    static void sortvar (){
        Map <String,Var> treesort=new TreeMap<>(varMap);

        System.out.println(treesort);
    }

    static Var createVar (String operand) {
        operand = operand.trim().replace("\\s", "");
        if (operand.matches(Patterns.SCALAR)) {
            return new Scalar(operand);
        }
        if (operand.matches(Patterns.VECTOR)) {
            return new Vector(operand);
        }
        if (operand.matches(Patterns.MATRIX)) {
            return new Matrix(operand);
        }
        if (varMap.containsKey(operand)){
            return varMap.get(operand);
        }
        else
            return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычетания " + this + "-" + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + "*" + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + "/" + other + " невозможна");
        return null;
    }
}

