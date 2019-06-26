package by.it.livanovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static List<Buyer> buyerList = new ArrayList<>();
    static int c = 0;

    public static void main(String[] args) throws InterruptedException {
        int countBuyer = 0;
        for (int t = 1; t < 120; t++) {
            if (t > 30 && t < 60) {
                int count = Rnd.Rnd(2);
                for (int i = 1; i <= count; i++) {
                    countBuyer++;
                    Buyer buyer = new Buyer(countBuyer);
                    int d = coutStrem();
                    if (buyerList.size() - d < 40 + (30 - t)) {
                        buyer.start();
                        buyerList.add(buyer);
                    } else Thread.sleep(1000);
                }
            } else {
                int count = Rnd.Rnd(2);
                for (int i = 1; i <= count; i++) {
                    countBuyer++;
                    Buyer buyer = new Buyer(countBuyer);
                    buyer.start();
                    buyerList.add(buyer);

                }
            }
        }
    }

    public static int coutStrem() {
        for (Buyer el : buyerList) {
            try {
                el.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            c++;
        }
        return c;
    }
}
