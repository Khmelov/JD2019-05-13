package by.it.lasotskaya.calc;

import java.util.*;

abstract class Var implements Operation{
    static Map<String,Var> vars= new HashMap<>();
    static CreateFabricVar factory = new CreateFabricVar();

    static Var saveVar(String nameVar, Var valueVar){
        vars.put(nameVar, valueVar);
        return valueVar;
    }
    static Set<Map.Entry<String, Var>> printvar(){
        Set<Map.Entry<String, Var>> setv = vars.entrySet();
        System.out.println(setv);
        Iterator<Map.Entry<String, Var>> iteratorI = setv.iterator();
        while (iteratorI.hasNext()){
            Map.Entry<String, Var> values = iteratorI.next();
            System.out.println(values.getKey() + "=" + values.getValue());        }
        return setv;
    }

    static void sortvar(){
        Map<String,Var> sorted = new TreeMap<>(vars);
        System.out.println(sorted);

    }
    static Var createVar(String strVar) throws CalcException {
        return factory.getVar(strVar);
        /*
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        else if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        else if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (strVar.matches(Patterns.VARNAME))
            return vars.get(strVar);
        throw  new CalcException("не понимаю,ошибка "+strVar);
        */
    }


    @Override
    public Var add(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s + %s невозможна%n", this, other));
    }

    @Override
    public Var sub(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s - %s невозможна%n", this, other));
    }

    @Override
    public Var mul(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s * %s невозможна%n", this, other));
    }

    @Override
    public Var div(Var other) throws CalcException {
        throw new CalcException(String.format("Операция %s / %s невозможна%n", this, other));
    }
    @Override
    public String toString(){
        return "Abstract class";
    }


}