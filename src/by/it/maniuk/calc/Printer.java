package by.it.maniuk.calc;


import java.util.Map;
import java.util.Set;

class Printer {

    void print(Var result) {

        if (result != null) {
            System.out.println(result);
        }
    }
    static void printVar(){
        Set<Map.Entry<String, Var>> entrySet = Var.getVars().entrySet();
        for (Map.Entry<String, Var> varEntry : entrySet) {
            System.out.println(varEntry.getKey() + "=" +varEntry.getValue());
        }
    }
    static void sortVar(){
        Map<String, Var> sort = Var.getVars();
        Set<Map.Entry<String, Var>> entrySet = sort.entrySet();
        for (Map.Entry<String, Var> me : entrySet) {
            System.out.println(me.getKey() + " : " + me.getValue());
        }
    }
}
