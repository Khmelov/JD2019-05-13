package by.it.adamovichjr.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    private static int numberOfBuyers = 1;
    private static List<Thread> threads = new ArrayList<>();
    private static int time = 1;

    public static void main(String[] args) {
        System.out.println("Market opened");
        startCashierWork();
        startMarketWork();
        joinBuyersAndCashirs(threads);
        System.out.println("Market closed");
    }

    private static void startCashierWork() {
        for (int i = 1; i <= Dispetcher.numberOfCashier; i++) {
            Cashier cashier = new Cashier(i);
            threads.add(cashier);
            System.out.println("Cashier go to work place");
        }
    }

    private static void startMarketWork() {
        while (Dispetcher.marketIsOpen()) {

            int limitBuyers = getLimitBuyers(time);
            int additionalBuyers = (limitBuyers - Dispetcher.countBuyerInMarket);
            int newBuyers = Time.fromTo(0, 2) + additionalBuyers;
            lettingInNewBuyers(newBuyers);
            System.out.println("Time = " + (time) + " count buyers in market = " + Dispetcher.countBuyerInMarket + " Cashiers wait = " + Queue.dequeCashiersWait.size() + " Buyers in queue = " +Queue.dequeBuyers.size() + " PENSIONERS in Q = " + Queue.dequePensionerBuyer.size());
            time++;
            Time.sleep(1000);

        }
    }

    private static int getLimitBuyers(int time) {
        int limitBuyers;
        if (time % 60 <= 30) {
            limitBuyers = (time % 60) + 10;
        } else {
            limitBuyers = 40 + (30 - (time % 60));
        }
        return limitBuyers;
    }

    private static void lettingInNewBuyers(int newBuyers) {
        for (int i = 0; i < newBuyers && Dispetcher.marketIsOpen(); i++) {
            Buyer buyer = new Buyer(numberOfBuyers++);
            threads.add(buyer);
        }
    }

    private static void joinBuyersAndCashirs(List<Thread> threads) {
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
