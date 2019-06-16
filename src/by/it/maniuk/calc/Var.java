package by.it.maniuk.calc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {

   private static Map<String, Var> vars = new HashMap<>();


   static  void printVar(){
       for (int i = 0; i < vars.size(); i++) {
           System.out.println(vars.get(i) + " : " + vars.get(i));
       }


       }


   static Var saveVar(String name, Var var){
        vars.put(name, var);

        return  var;
   }

   static void sortVar(){
       // вывод хэш-таблицы с помощью методов интерфейса Map.Entry<K,V>
       Set<Map.Entry<String, Var>> setv = vars.entrySet();
       Iterator<Map.Entry<String, Var>> i = setv.iterator();
       while (i.hasNext()) {
           Map.Entry<String, Var> me = i.next();
           System.out.println(me.getKey() + " : " + me.getValue());
       }
   }


    static Var createVar(String strVar) {
        strVar = strVar.replaceAll("\\s+", "");
        if (strVar.matches(Patterns.SCALAR))
            return new Scalar(strVar);
        if (strVar.matches(Patterns.VECTOR))
            return new Vector(strVar);
        if (strVar.matches(Patterns.MATRIX))
            return new Matrix(strVar);
        if (vars.containsKey(strVar))
            return vars.get(strVar);
        return null;
    }

    @Override
    public Var add(Var other) {
        System.out.println("Операция сложения "+this+ "+" + other + " невозможна");
        return null;
    }

    @Override
    public Var sub(Var other) {
        System.out.println("Операция вычитания  "+this+ "-" + other + " невозможна");
        return null;
    }

    @Override
    public Var mul(Var other) {
        System.out.println("Операция умножения "+this+ "*" + other + " невозможна");
        return null;
    }

    @Override
    public Var div(Var other) {
        System.out.println("Операция деления "+this+ "/" + other + " невозможна");
        return null;
    }

    @Override
  public String toString(){
      return "abstract var";
  }

}
