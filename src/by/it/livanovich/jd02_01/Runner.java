package by.it.livanovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static List<Buyer> buyerList = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("Магазин открыт");
        int countBuyer = 0;
        for (int t = 1; t < 120; t++) {
            int count = Rnd.Rnd(2);
            for (int i = 0; i <= count; i++) {
                countBuyer++;
                Buyer buyer = new Buyer(countBuyer);
                if (t > 30 && t < 60) {
                    while (Thread.activeCount() >= 40 + (30 - t)) {
                        Thread.sleep(1000);
                    }
                    buyer.start();
                    buyerList.add(buyer);
                } else
                    buyer.start();
                buyerList.add(buyer);
            }
        }
        for (Buyer buyer : buyerList) {
            buyer.join();
        }
        System.out.println("Магазин закрыт");
    }
}
