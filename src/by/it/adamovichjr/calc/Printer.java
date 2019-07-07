package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.report.Director;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {
    public void print(Var result) {
        String res = "Результат: " + result.toString();
        SingeltonLogger.LOGGER.writeLogInFile(res);
        Director.DIRECTOR.putEventToDirector(res);
        System.out.println(res);
    }


    void printvar(Map<String, Var> operand){
        Set<Map.Entry<String, Var>> enSet = operand.entrySet();
        Iterator<Map.Entry<String, Var>> iter = enSet.iterator();
        while (iter.hasNext()){
            Map.Entry<String, Var> elem = iter.next();
            SingeltonLogger.LOGGER.writeLogInFile(elem.getKey() + " = " + elem.getValue());
            Director.DIRECTOR.putEventToDirector(elem.getKey() + " = " + elem.getValue());
            System.out.println(elem.getKey() + " = " + elem.getValue());
        }
    }

    void sortvar() {
        Map<String, Var> sortOperand = Var.getVars();
        printvar(sortOperand);
    }
}
