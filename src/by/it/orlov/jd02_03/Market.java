package by.it.orlov.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    public static void main(String[] args) {
        System.out.println("Market opened");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();

        int numberBuyer = 0;
        while (Dispatcher.marketIsOpened()) {
            int count = Util.rnd(2);
            for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
            }
            Util.sleep(1000);
        }

        while (!executorService.isTerminated()) {
            Util.sleep(100);
        }
        System.out.println("Market closed");
    }
}
