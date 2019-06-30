package by.it.tbabich.jd02_01;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Market {
    private static List<Buyer> buyers = new CopyOnWriteArrayList<>();
    private static int countBuyer;

    public static void main(String[] args) {
        System.out.println("Market opened");
        countBuyer = 0;
        for (int counter = 0; counter < 120; counter++) {
            int time = 0;
            if (counter > 60) {
                time = counter % 60;
            } else time = counter;
            if ((time >= 30 && time < 60 && (buyers.size() <= 40 + (30 - time)) || (time >= 0 && time < 30))) {
                visitorLaunch();
            }
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
    }

    private static void visitorLaunch() {
        int count = Util.rnd(2);
        for (int i = 0; i < count; i++) {
            Buyer buyer = new Buyer(++countBuyer);
            if ((countBuyer + 1) % 4 == 0) {
                buyer.setPensioneer(true);
            }
            buyer.start();
            buyers.add(buyer);
        }
    }

    static void deleteBuyer(Buyer buyer) {
        buyers.remove(buyer);
    }
}
