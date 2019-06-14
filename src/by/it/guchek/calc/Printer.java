package by.it.guchek.calc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {
    void print (Var var){       //метод печатает переменную var в консоль
        if (var !=null){
            System.out.println(var);
        }
    }

    static void printMap() {

        Set<Map.Entry<String, Var>> setv = Var.vars.entrySet();
        //System.out.println(setv);
        Iterator<Map.Entry<String, Var>> i = setv.iterator();
        while (i.hasNext()) {
            Map.Entry<String, Var> ne = i.next();
            System.out.println(ne.getKey() + " : " + ne.getValue());
        }

    }
}
