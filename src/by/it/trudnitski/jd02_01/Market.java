package by.it.trudnitski.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        List<Buyer> buyers=new ArrayList<>();
        System.out.println("Market opened");

        int countBuyer=0;
        for (int time = 0; time <120 ; time++) {

            int count=Helper.randomeGet(0,2);
            for (int i = 0; i < count; i++) {
                Buyer buyer=new Buyer(++countBuyer);
                buyer.start();
                buyers.add(buyer);

            }
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
