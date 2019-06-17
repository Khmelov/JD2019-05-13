package by.it.guchek.calc;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {


    void print (Var var){       //метод печатает переменную var в консоль
        if (var !=null){
            System.out.println(var);
        }
    }

    void printMap( ) {

        Set<Map.Entry<String, Var>> setv = Var.getVars().entrySet();
        Iterator<Map.Entry<String, Var>> i = setv.iterator();

        while (i.hasNext()) {
            Map.Entry<String, Var> ne = i.next();
            System.out.println(ne.getKey() + " = " + ne.getValue());
        }

    }

    void sortvar() {
        Map<String, Var> sortedForKeys = Var.getVars();
        Set<Map.Entry<String, Var>> setv = sortedForKeys.entrySet();
        Iterator<Map.Entry<String, Var>> i = setv.iterator();

        while (i.hasNext()) {
            Map.Entry<String, Var> ne = i.next();
            System.out.println(ne.getKey() + " = " + ne.getValue());
        }
        //printMap(sortedForKeys);

    }
}
