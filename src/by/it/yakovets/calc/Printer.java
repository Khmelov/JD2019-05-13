package by.it.yakovets.calc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {

    void print (Var variable){
        System.out.println(variable);
    }
    static void printvar() {
        Set<Map.Entry<String, Var>> sett = Var.vars.entrySet();
        Iterator<Map.Entry<String, Var>> i = sett.iterator();
        while (i.hasNext()){
            Map.Entry<String, Var> next = i.next();
            System.out.println(next.getKey()+"="+next.getValue());
        }
    }
//    static void sortvar() {
//        Set<Map.Entry<String, Var>> sett = Var.vars.entrySet();
//        Iterator<Map.Entry<String, Var>> i = sett.iterator();
//        Var.vars.co
//        while (i.hasNext()){
//            Map.Entry<String, Var> next = i.next();
//            System.out.println(next.getKey()+"="+next.getValue());
//        }
//    }
}
