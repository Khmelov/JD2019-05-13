package by.it.dnevar.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        List<Buyer> buyers = new ArrayList<>();

        System.out.println("Market open");

        int countBuyerForName = 0;

        for (int time = 0; time < 120; time++) {

            if ((time%60 >= 30 && time%60 < 60 && (buyers.size() <= 40 + (30 - time%60)) || (time%60 >= 0 && time%60 < 30))){
            int count = Util.rnd(2);
                for (int i = 0;i<count;i++) {
                    Buyer buyer = new Buyer(++countBuyerForName);
                    buyer.start();
                    buyers.add(buyer);
                }
            }
            Util.sleep(1000);
        }

        for (Buyer buy : buyers) {
            try {
                buy.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Marked close");
    }
}
