package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.ResData;

import java.util.*;

class Printer {

    void print(Var variable) {
        System.out.printf(ResourceManager.INSTANCE.getString(ResData.RESULT), variable);
    }

    void printVar () {
        Map<String, Var> list = VarList.getList();

        if (list.isEmpty()) System.out.println(ResourceManager.INSTANCE.getString(ResData.NO_SAVED_VARIABLE));

        Set<Map.Entry<String, Var>> entries = list.entrySet();
        for (Map.Entry<String, Var> next : entries) {
            System.out.printf("%s = %s\n", next.getKey(), next.getValue());
        }
    }

    void printSortedVar () {
        Map<String, Var> listSorted = new TreeMap<>(VarList.getList());

        if (listSorted.isEmpty()) System.out.println(ResourceManager.INSTANCE.getString(ResData.NO_SAVED_VARIABLE));

        Set<Map.Entry<String, Var>> entries = listSorted.entrySet();
        for (Map.Entry<String, Var> next : entries) {
            System.out.printf("%s = %s\n", next.getKey(), next.getValue());
        }
    }
}
