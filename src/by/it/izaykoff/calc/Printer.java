package by.it.izaykoff.calc;

import java.util.Map;

class Printer {
    void print(Var var) {
        if (var != null)
            System.out.println(var);
    }

    public static void printVar() {
        for (Map.Entry<String, Var> entry : Var.getVars().entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    public static void printSortVar() {
        for (Map.Entry<String, Var> entry : Var.getVars().entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }


}
