package by.it.aadamovich.calc;

import java.util.*;

class Printer {

    void print(Var variable) {
        System.out.printf("Результат: %s%n", variable);
    }

    void printVar () {
        Map<String, Var> list = VarList.getList();
        Set<Map.Entry<String, Var>> entries = list.entrySet();
        for (Map.Entry<String, Var> next : entries) {
            System.out.printf("%s = %s\n", next.getKey(), next.getValue());
        }
    }

    void printSortedVar () {
        Map<String, Var> listSorted = new TreeMap<>(VarList.getList());
        Set<Map.Entry<String, Var>> entries = listSorted.entrySet();
        for (Map.Entry<String, Var> next : entries) {
            System.out.printf("%s = %s\n", next.getKey(), next.getValue());
        }
    }
}
