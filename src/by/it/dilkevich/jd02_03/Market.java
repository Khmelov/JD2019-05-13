package by.it.dilkevich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class Market {

    public static void main(String[] args) {

        System.out.println("Market opened");

        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();

        int numberBuyer = 0;

        ExecutorService buyersExService = Executors.newFixedThreadPool(100);
        while (Dispatcher.marketIsOpened()) {

            int count = Util.rnd(2);
            for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) {

                buyersExService.execute(new Buyer(++numberBuyer));
            }
            Util.sleep(1000);
        }
        buyersExService.shutdown();

        while (!executorService.isTerminated()) {
            Util.sleep(100);
        }
        while (!buyersExService.isTerminated()) {
            Util.sleep(100);
        }
        System.out.println("Market closed");
    }
}
