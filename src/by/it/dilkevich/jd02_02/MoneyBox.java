package by.it.dilkevich.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class MoneyBox {

    static Map<String, Double> cashBoxJournal = new HashMap<>();

    static {

        cashBoxJournal.put("Кассир №1", 0.);
        cashBoxJournal.put("Кассир №2", 0.);
        cashBoxJournal.put("Кассир №3", 0.);
        cashBoxJournal.put("Кассир №4", 0.);
        cashBoxJournal.put("Кассир №5", 0.);
        cashBoxJournal.put("итог", 0.);
    }

    synchronized static Double getCashBoxJournal(String name) {
        return cashBoxJournal.get(name);
    }


    synchronized static void printReport(){

        int klientsInQueue = Plan.getKlientsInQueue();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("         Касса 1      Касса 2      Касса 3      Касса 4      Касса 5      Очередь");
        System.out.printf("Выручка  %6.2f%13.2f%13.2f%13.2f%13.2f%13d%13.2f",

                getCashBoxJournal("Кассир №1"),
                getCashBoxJournal("Кассир №2"),
                getCashBoxJournal("Кассир №3"),
                getCashBoxJournal("Кассир №4"),
                getCashBoxJournal("Кассир №5"),
                klientsInQueue,
                getCashBoxJournal("итог"));
        System.out.println();
        System.out.println("---------------------------------------------------------------------------");
    }

}
