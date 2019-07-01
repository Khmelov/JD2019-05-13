package by.it.adamovichjr.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {

    private static int startNumberOfBuyers = 1;
    private static int time = 1;

    public static void main(String[] args) {
        System.out.println("Market opened");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= Dispetcher.NUMBER_OF_CAHIRS; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();
        System.out.println("Cashier go to work place");
        startMarketWork();
        while (!executorService.isTerminated()) {
            Time.sleep(100);
        }

        System.out.println("Market closed");
    }


    private static void startMarketWork() {
        while (Dispetcher.marketIsOpen()) {
            int limitBuyers = getLimitBuyers(time);
            int additionalBuyers = (limitBuyers - Dispetcher.getCountBuyerInMarket());
            int newBuyers = Time.fromTo(0, 2) + additionalBuyers;
            lettingInNewBuyers(newBuyers);
                    System.out.println("Time = " + (time) + " count buyers in market = " + Dispetcher.getCountBuyerInMarket() + " Cashiers wait = " + Queue.dequeCashiersWait.size() + " Buyers in queue = " +(Queue.dequeBuyers.size()+ Queue.dequePensionerBuyer.size()) + " PENSIONERS in Q = " + Queue.dequePensionerBuyer.size());
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
            Buyer buyer = new Buyer(startNumberOfBuyers++);
        }
    }
}
