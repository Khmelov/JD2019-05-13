package by.it.aadamovich.calc;

import by.it.aadamovich.calc.names.ResData;

import java.util.*;

class Printer {

    private Logger logger = Logger.LOGGER;

    void print(String message) {
        System.out.println(message);
        logger.writeLog(message);
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
    }

    void printVar() {
        Map<String, Var> list = VarList.getList();
        if (list.isEmpty()) {
            print(ResourceManager.INSTANCE.getString(ResData.NO_SAVED_VARIABLE));
        } else {
            varlistConsoleAndLogOut(list);
        }
    }

    void printSortedVar() {
        Map<String, Var> listSorted = new TreeMap<>(VarList.getList());
        if (listSorted.isEmpty()) {
            print(ResourceManager.INSTANCE.getString(ResData.NO_SAVED_VARIABLE));
        } else {
            varlistConsoleAndLogOut(listSorted);
        }
    }

    private void varlistConsoleAndLogOut(Map<String, Var> list) {
        String entry;
        Set<Map.Entry<String, Var>> entries = list.entrySet();
        for (Map.Entry<String, Var> next : entries) {
            entry = String.format("%s = %s", next.getKey(), next.getValue());
            print(entry);
        }
    }
}
