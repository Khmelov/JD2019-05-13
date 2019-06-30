package by.it.maniuk.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Market {
    private static int countAllBuyers = 0;

    public static void main(String[] args) {
        List<Thread> threads=new ArrayList<>();
        System.out.println("Market opened");

        cashierInWork();
        marketStartedWork(threads);


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }

    private static void marketStartedWork(List<Thread> threads) {
        while (Dispatcher.marketIsOpened()) {
            int countBuyerInSecond;
            for (int time = 0; time < 120; time++) {
                int second = time % 60;
                if ((second <= 30)) {
                    countBuyerInSecond = Util.rnd(2) + (second + 10);

                } else {
                    countBuyerInSecond = (40 + (30 - second));

                }

                for (int i = 0; i < countBuyerInSecond && Dispatcher.marketIsOpened(); i++) {
                        Buyer buyer = new Buyer( ++ countAllBuyers);
                        threads.add(buyer);
                        buyer.start();
                }
                Util.sleep(1000);
            }
        }}


    private static void cashierInWork() {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 2; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();
        }
    }
