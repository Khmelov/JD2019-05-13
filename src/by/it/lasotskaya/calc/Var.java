package by.it.lasotskaya.calc;

import java.util.*;

abstract class Var implements Operation{
    private static Map<String,Var> vars= new HashMap<>();
    private static Object SortedMap;

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
    static Var createVar(String strVar){
        strVar=strVar.trim().replace("\\s+","");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (vars.containsKey(strVar)){
            return vars.get(strVar);
        }
//    if (strVar.matches(Pattern.MATRIX))
//      return new Matrix(strVar);
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this + "+"+other+ " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания "+this + "-"+other+ " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "+this + "*"+other+ " невозможна");

        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this + "/"+other+ " невозможна");

        return null;
    }

    @Override
    public String toString(){
        return "Abstract class";
    }


}