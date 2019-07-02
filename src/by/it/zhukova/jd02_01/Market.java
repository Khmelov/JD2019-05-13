package by.it.zhukova.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>();
        System.out.println("Market opened");
        MarketOpen(buyers);
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market closed");
    }

    private static void MarketOpen(List<Buyer> buyers) {
        int countBuyer=0;
        boolean pensioneer;
        int count =Util.rnd(2);
        for (int min = 0; min < 2; min++) {
            for (int time = 0; time < 60; time++) {
                int N = 0;
                //подсчет людей в магазине
                for (Buyer buyer : buyers) {
                    if (!(buyer.getState().equals("TERMINATED"))) {
                        ++N;
                    }
                }
                if ((time > 30)&&(N > 40 + (30 - time))) {
                    count = 0;
                }
                for (int i = 0; i < count; i++) {
                    ++countBuyer;
                    if (countBuyer % 4 == 0) {
                        pensioneer = true;
                    } else {
                        pensioneer = true;
                    }
                    Buyer buyer = new Buyer(countBuyer, pensioneer);
                    buyer.start();
                    buyers.add(buyer);
                }
                Util.sleep(1000);
            }
        }
    }
}
