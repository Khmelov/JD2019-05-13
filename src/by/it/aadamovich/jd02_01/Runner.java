package by.it.aadamovich.jd02_01;

import java.util.ArrayList;

public class Runner {

    static int countBuyersInMarket = 0;

    public static void main(String[] args) {

        ArrayList<Buyer> buyers = new ArrayList<>();

        int countBuyer = 0;
        int limitBuyer;      // desired quantity of buyers in the market at given second

        System.out.println("Market is opened");
        for (int time = 0; time < 120; time++) {
            if (time % 60 <= 30) {
                limitBuyer = (time % 60) + 10;
            } else {
                limitBuyer = 40 + (30 - (time % 60));
            }
            int count = Util.getRandom(0, 2) + (limitBuyer - countBuyersInMarket);
            while (count > 0) {
                Buyer buyer = new Buyer(++countBuyer);
                buyers.add(buyer);
                countBuyersInMarket++;
                count--;
            }
//            System.out.println("Time: " + (time) + " Count: " + countBuyersInMarket); // for testing
            Util.sleep(1000, 100);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market is closed");
    }
}
