package by.it.yakovets.calc;

import java.util.*;

public class Printer {

    void print(Var variable) {
        System.out.println(variable);
    }

    void printvar() {
        Iterator<Map.Entry<String, Var>> i = Var.vars.entrySet().iterator();
        while (i.hasNext()) {
            Map.Entry<String, Var> me = i.next();
            System.out.println(me.getKey() + " = " + me.getValue());

        }
    }
        void sotrvar() {
            Map<String, Var> treeMap = new TreeMap<>(Var.vars);
            System.out.println(treeMap);
        }
    }



