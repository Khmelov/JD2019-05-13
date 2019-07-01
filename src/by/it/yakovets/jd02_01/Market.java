package by.it.yakovets.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static int countBuyer = 0;

    private static List<Buyer> buyers = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Market opened");
        marketWorking();
    }

    private static void marketWorking() {
        for (int time = 0; time < 120; time++) {
            int maxBuyers;

            if (time % 60 <= 30) {
                maxBuyers = (time % 60) + 10;
            } else {
                maxBuyers = 40 + (30 - (time % 60));
            }
            int countAddBuyers = maxBuyers - Dispatcher.buyerInMarket;
            for (int i = 0; i < countAddBuyers; i++) {
                Buyer buyer;
                if (Helper.rnd(1, 4) == 1) {
                    buyer = new Buyer(++countBuyer, true);
                } else {
                    buyer = new Buyer(++countBuyer);
                }
                buyer.start();
                buyers.add(buyer);

            }
            System.out.println("Time " + (time) + " Buyers in market " + Dispatcher.buyerInMarket);
            Helper.sleep(1000);
        }

        for (Buyer buyer : buyers) {

            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }
}