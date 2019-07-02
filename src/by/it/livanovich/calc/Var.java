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
            String key = entry.getKey();
            String value = entry.getValue().toString();
            System.out.printf("%s = %s\n", key, value);
        }
    }
    static void sortvar (){
        Map <String,Var> treesort=new TreeMap<>(varMap);

        System.out.println(treesort);
    }

    static Var createVar (String operand) throws CalcException {
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
            throw new CalcException ("невозможно создать переменную");
    }

    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException("Операция сложения " + this + "+" + other + " невозможна");
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException ("Операция вычетания " + this + "-" + other + " невозможна");
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException("Операция умножения " + this + "*" + other + " невозможна");
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException("Операция деления " + this + "/" + other + " невозможна");
    }
}

