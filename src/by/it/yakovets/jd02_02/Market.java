package by.it.yakovets.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static int countBuyer = 0;
    private static List<Thread> threads = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Market opened");
        for (int i = 1; i <=5; i++) {
            Cashier cashier = new Cashier(i);
            threads.add(cashier);
        }
        marketWorking();
        joinAllThreads();
        System.out.println("Market closed");
    }

    private static void marketWorking() {
        int time = 0;
        while (Dispatcher.marketIsOpened()) {
            int maxBuyers = getMaxBuyers(time);
            int countAddBuyers = maxBuyers - Dispatcher.buyerInMarket;
            addBuyersInMarket(countAddBuyers);
            System.out.println("Time " + time + " Buyers in market " + Dispatcher.buyerInMarket);
            time++;
            Helper.sleep(1000);
        }

    }

    private static void addBuyersInMarket(int countAddBuyers) {
        for (int i = 0; i < countAddBuyers && Dispatcher.marketIsOpened(); i++) {
            Buyer buyer;
            if (Helper.rnd(1, 4) == 1) {
                buyer = new Buyer(++countBuyer, true);
            } else {
                buyer = new Buyer(++countBuyer);
            }
            threads.add(buyer);

        }
    }

    private static void joinAllThreads() {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
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