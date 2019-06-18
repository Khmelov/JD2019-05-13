package by.it.izaykoff.Calc;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Printer {
    void print(Var var){
        if (var!=null)
            System.out.println(var);
    }
    void printvar(Map<String, Var> operand){
        Set<Map.Entry<String, Var>> enterSet = operand.entrySet();
        Iterator<Map.Entry<String, Var>> iter = enterSet.iterator();
        while (iter.hasNext()){
            Map.Entry<String, Var> element = iter.next();
            System.out.println(element.getKey() + " = " + element.getValue());
        }
    }

    void sortvar() {
        Map<String, Var> sortOperand = Var.getVars();
        printvar(sortOperand);
    }
}
