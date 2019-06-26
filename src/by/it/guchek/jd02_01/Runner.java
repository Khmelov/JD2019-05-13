package by.it.guchek.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    private static int countBuyers;
    static boolean pensioneer=false;

    public static void main(String[] args) {
        List<Buyer> buyers=new ArrayList<>();
        System.out.println("Магазин открыт");

        for (int time = 0; time < 120/60; time++) {           //запускаем в течении 2 минут
            int countEntered=RandCount.randFrTo(2);  //от 0 до 2 покупателей в сек
            for (int i = 0; i < countEntered; i++) {
                Buyer buyer=new Buyer(++countBuyers);
                if (countBuyers%4==0) pensioneer=true;
                buyer.start();
                buyers.add(buyer);
            }
            RandCount.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
