package by.it.buymistrov.jd02_01;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Market {
    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>();
        Set<Buyer> activeBuyers = new HashSet<>();
        System.out.println("Market opened");
        int countBuyer = 0;

        for (int time = 0; time < 120; time++) {
            int firstHalf = Util.rnd(2) + (time % 60) + 10- activeBuyers.size();
            int secondHalf = Util.rnd(2) + 40 + (30 - time % 60) - activeBuyers.size();
            if (time % 60 <= 30) {
                for (int i = 0; i < firstHalf; i++) {
                    Buyer buyer = new Buyer(++countBuyer);
                    buyer.start();
                    buyers.add(buyer);
                }
            } else {
                for (int i = 0; i < secondHalf; i++) {
                    Buyer buyer = new Buyer(++countBuyer);
                    buyer.start();
                    buyers.add(buyer);
                }
            }

            for (Buyer buyer : buyers) {
                if (buyer.getState() != Thread.State.TERMINATED) {
                    activeBuyers.add(buyer);
                }
                if (buyer.getState() == Thread.State.TERMINATED) {
                    activeBuyers.remove(buyer);
                }

            }
            System.out.println("TIME " + time);
            System.out.println(activeBuyers.size());
            Util.sleep(1000);
        }

        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market closed");
        System.out.println("Всего покупателей " + countBuyer);
    }
}
