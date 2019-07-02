package by.it.aadamovich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) {

        System.out.println("Market is opened");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i < 6; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();

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
                new Buyer(++numberBuyer);
                count--;
            }
//            System.out.println(" IN: " + Dispatcher.getBuyersInMarket() + " QueueSize: " + Queue.getQueueSize() + " Cash: " + Queue.cashierInWork()); // for testing
            Util.sleep(1000);
        }

        while (!executorService.isTerminated()) {
            Util.sleep(200);
        }

        System.out.println("Market is closed");
    }
}
