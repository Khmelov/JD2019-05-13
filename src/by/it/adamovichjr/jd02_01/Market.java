package by.it.adamovichjr.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    static int countBuyerInMarket = 0;
    private static List<Buyer> buyers = new ArrayList<>();
    private static int countBuyer = 0;

    public static void main(String[] args) {
        System.out.println("Market opened");
        startMarketWork();
        joinBuyers(buyers);
        System.out.println("Market closed");
    }

    private static void startMarketWork() {
        for (int time = 0; time < 120; time++) {
            int limitBuyers = getLimitBuyers(time+1);
            int additionalBuyers = (limitBuyers - countBuyerInMarket);
            int newBuyers = Time.fromTo(0, 2) + additionalBuyers;
            lettingInNewBuyers(newBuyers);
            Time.sleep(1000);
            System.out.println("Time " + (time+1) +" count buyers " + countBuyerInMarket );
        }
    }

    private static int getLimitBuyers(int time) {
        int limitBuyers;
        if(time % 60 <= 30){
            limitBuyers = (time%60) + 10;
        }else {
            limitBuyers = 40 + (30 - (time%60));
        }
        return limitBuyers;
    }

    private static void lettingInNewBuyers(int newBuyers) {
        for (int i = 0; i < newBuyers; i++) {
            Buyer buyer = new Buyer(++countBuyer);
            buyers.add(buyer);
        }
    }

    private static void joinBuyers(List<Buyer> buyers) {
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
