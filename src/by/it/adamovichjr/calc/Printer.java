package by.it.adamovichjr.calc;

import by.it.adamovichjr.calc.report.ChoseReport;
import by.it.adamovichjr.calc.report.Director;
import by.it.adamovichjr.calc.text.All_messages;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Printer {
    public void print(Var result) {
        String res = ResourceManager.INSTANCE.get(All_messages.RESULT) + result.toString();
        SingeltonLogger.LOGGER.writeLogInFile(res);
        if (ChoseReport.needReport) {
            Director.DIRECTOR.putEventToDirector(res);
        }
        System.out.println(res);
    }


    void printvar(Map<String, Var> operand){
        Set<Map.Entry<String, Var>> enSet = operand.entrySet();
        Iterator<Map.Entry<String, Var>> iter = enSet.iterator();
        while (iter.hasNext()){
            Map.Entry<String, Var> elem = iter.next();
            SingeltonLogger.LOGGER.writeLogInFile(elem.getKey() + " = " + elem.getValue());
            if (ChoseReport.needReport) {
                Director.DIRECTOR.putEventToDirector(elem.getKey() + " = " + elem.getValue());
            }
            System.out.println(elem.getKey() + " = " + elem.getValue());
        }
    }

    void sortvar() {
        Map<String, Var> sortOperand = Var.getVars();
        printvar(sortOperand);
    }
}
