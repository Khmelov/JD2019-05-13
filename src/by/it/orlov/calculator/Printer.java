package by.it.orlov.calculator;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {
    void print(Var variable){
        System.out.println(variable);
    }



    void printvar(Map<String, Var> operand){
        Set<Map.Entry<String, Var>> enSet = operand.entrySet();
        Iterator<Map.Entry<String, Var>> iter = enSet.iterator();
        while (iter.hasNext()){
            Map.Entry<String, Var> elem = iter.next();
            System.out.println(elem.getKey() + " = " + elem.getValue());
        }
    }

    void sortvar() {
        Map<String, Var> sortOperand = Var.getVars();
        printvar(sortOperand);
    }
}
