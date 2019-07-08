package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.ResData;
import by.it.aadamovich.calc.reportBuilder.Director;

import java.util.*;

class Printer {

    private LoggerSingletone logger = LoggerSingletone.LOGGER;

    void print(String message) {
        System.out.println(message);
        logger.writeLog(message);
        Director.DIRECTOR.addEvent(message);
    }

    void print(Var variable) {
        String result = String.format
                (ResourceManager.INSTANCE.getString(ResData.RESULT), variable);
        print(result);
    }

    void print(Throwable e) {
        System.out.println(e.getMessage());
        logger.writeLog(e);
    }

    void logData(String message) {
        logger.writeLog(message);
        Director.DIRECTOR.addEvent(message);
    }

    void printVar() {
        Map<String, Var> list = VarList.getList();
        if (list.isEmpty()) {
            print(ResourceManager.INSTANCE.getString(ResData.NO_SAVED_VARIABLE));
        } else {
            varlistToConsoleAndLogOut(list);
        }
    }

    void printSortedVar() {
        Map<String, Var> listSorted = new TreeMap<>(VarList.getList());
        if (listSorted.isEmpty()) {
            print(ResourceManager.INSTANCE.getString(ResData.NO_SAVED_VARIABLE));
        } else {
            varlistToConsoleAndLogOut(listSorted);
        }
    }

    private void varlistToConsoleAndLogOut(Map<String, Var> list) {
        String entry;
        Set<Map.Entry<String, Var>> entries = list.entrySet();
        for (Map.Entry<String, Var> next : entries) {
            entry = String.format("%s = %s", next.getKey(), next.getValue());
            print(entry);
        }
    }
}
