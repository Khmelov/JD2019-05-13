package by.it.aadamovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();
        Buyer buyer;
        Cashier cashier;
        System.out.println("Market is opened");

        for (int i = 0; i < 5; i++) {
            cashier = new Cashier(i + 1);
            threads.add(cashier);
        }

        int limitBuyer;      // desired quantity of buyers in the market at given second
        int numberBuyer = 0;

        for (int time = 0; Dispatcher.marketOpened(); time++) {
            if (time % 60 <= 30) {
                limitBuyer = (time % 60) + 10;
            } else {
                limitBuyer = 40 + (30 - (time % 60));
            }
            int count = Util.getRandom(2) + (limitBuyer - Dispatcher.getBuyersInMarket());
            while (count > 0 && Dispatcher.marketOpened()) {
                buyer = new Buyer(++numberBuyer);
                threads.add(buyer);
                count--;
            }
//            System.out.println(" Time " + time + " IN: " + Dispatcher.getBuyersInMarket() + " Queue: " + Queue.getQueueSize() + " Cash: " + Queue.cashierInWork()); // for testing
            Util.sleep(1000, 100);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed");
    }
}
