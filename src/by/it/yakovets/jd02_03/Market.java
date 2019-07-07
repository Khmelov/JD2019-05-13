package by.it.yakovets.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    private static int countBuyer = 0;


    public static void main(String[] args) {
        System.out.println("Market opened");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 5; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();
        marketWorking();
        while (!executorService.isTerminated()) {
            Helper.sleep(100);
        }

        System.out.println("Market closed");

    }

    private static void marketWorking() {
        int time = 0;
        while (Dispatcher.marketIsOpened()) {
            int maxBuyers = getMaxBuyers(time);
            int countAddBuyers = maxBuyers - Dispatcher.buyerInMarket.get();
            addBuyersInMarket(countAddBuyers);
            System.out.println("Time " + time + " Buyers in market " + Dispatcher.buyerInMarket);
            time++;
            Helper.sleep(1000);
        }

    }

    private static void addBuyersInMarket(int countAddBuyers) {
        for (int i = 0; i < countAddBuyers && Dispatcher.marketIsOpened(); i++) {
            if (Helper.rnd(1, 4) == 1) {
                new Buyer(++countBuyer, true);
            } else {
                new Buyer(++countBuyer);
            }

        }
    }


    private static int getMaxBuyers(int time) {
        int maxBuyers;
        if (time % 60 <= 30) {
            maxBuyers = (time % 60) + 10;
        } else {
            maxBuyers = 40 + (30 - (time % 60));
        }
        return maxBuyers;
    }
}