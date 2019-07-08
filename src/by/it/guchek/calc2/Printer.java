package by.it.guchek.calc2;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

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
        Map<String, Var> sortedForKeys = new TreeMap<>(Var.getVars());
        //Set<SortedMap.Entry<String, Var>> setv = sortedForKeys.entrySet();
        Iterator<Map.Entry<String, Var>> i = sortedForKeys.entrySet().iterator();

        while (i.hasNext()) {
            Map.Entry<String, Var> ne = i.next();
            System.out.println(ne.getKey() + " = " + ne.getValue());
        }
        //printMap(sortedForKeys);

    }
}
