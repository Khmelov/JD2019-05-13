package by.it.zhukova.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        System.out.println("Market opened");
        MarketOpen(threads);
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market closed");
    }

    private static void MarketOpen(List<Thread> threads) {
        // запуск кассиров
        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Cashier(i+1));
            threads.add(thread);
            thread.start();
        }

        int numberBuyer = 0;
        boolean pensioneer;
        while (Dispatcher.marketIsOpened()) {
            int count = Util.rnd(2);
            for (int min = 0; min < 2; min++) {
                for (int time = 0; time < 60; time++) {
                    int N = Dispatcher.buyerInMarket;
                    if ((time > 30) && (N > 40 + (30 - time))) {
                        count = 0;
                    }
                    for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) {
                        ++numberBuyer;
                        if (numberBuyer % 4 == 0) {
                            pensioneer = true;
                        } else {
                            pensioneer = true;
                        }
                        Buyer buyer = new Buyer(numberBuyer, pensioneer);
                        buyer.start();
                        threads.add(buyer);
                    }
                    Util.sleep(1000);
                }
            }
        }
    }
}
