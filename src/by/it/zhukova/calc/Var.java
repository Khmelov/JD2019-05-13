package by.it.zhukova.calc;

import java.util.*;
import java.util.stream.Stream;

abstract class Var implements Operation {

    private static Map<String, Var> vars = new HashMap<>();


    static Var createVar(String strVar){
        String strVar2=strVar.replaceAll("\\s+","");
if (strVar2.matches(Patterns.SCALAR)) return new Scalar(strVar2);
    else    if (strVar2.matches(Patterns.VECTOR)) return new Vector(strVar2);
    else    if (strVar2.matches(Patterns.MATRIX)) return new Matrix(strVar2);
    else    if (vars.containsKey(strVar)) return vars.get(strVar);
    else    return null;
    }

    static void save(String name, Var var) {
        vars.put(name, var);
    }

    static void printvar (){
        Set<Map.Entry<String, Var>> set = vars.entrySet();
        System.out.println(set);
        Iterator<Map.Entry<String, Var>> iterator = set.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Var> next = iterator.next();
            System.out.println(next.getKey()+"="+next.getValue());
        }
    }
    static void sortvar () {
        Map<String,Var> sortV = new TreeMap <String,Var>(vars);
        System.out.println(sortV);
   }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения " + this + "+" + other+ " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания " + this + "-" + other+ " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения " + this + "*" + other+ " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления " + this + "/" + other+ " невозможна");
        return null;
    }
}
