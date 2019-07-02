package by.it.trudnitski.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        System.out.println("Market opened");

        cashierInWork();

        int numberBuyer = 0;
        while (Dispatcher.marketIsOpen()) {
            int count = Helper.randomeGet(2);
            for (int i = 0; i < count && Dispatcher.marketIsOpen(); i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
                threads.add(buyer);
            }
            Helper.sleep(1000);
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }

    private static void cashierInWork() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();
    }
}
