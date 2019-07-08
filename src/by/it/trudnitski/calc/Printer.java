package by.it.trudnitski.calc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {
    void print(Var variable) {
        if (variable != null)
            System.out.println(variable);
    }

    void printvar(Map<String, Var> result) {
        Set<Map.Entry<String, Var>> enSet = result.entrySet();
        Iterator<Map.Entry<String, Var>> it = enSet.iterator();
        while (it.hasNext()) {
            Map.Entry<String, Var> elem = it.next();
            System.out.println(elem.getKey() + "=" + elem.getValue());
        }
    }

    void sortVar() {
        Map<String, Var> sort = Var.getVars();
        printvar(sort);
    }
}
