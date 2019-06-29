package by.it.maniuk.jd02_02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Market {
    private static List<Buyer> buyers = new ArrayList<>();
    private static int countAllBuyers = 0;

    public static void main(String[] args) {
        List<Thread> threads=new ArrayList<>();

        System.out.println("Market opened");

        for (int i = 0; i <2 ; i++) {
           Thread thread = new Thread(new Cashier(i));
            threads.add(thread);
            thread.start();
        }
        int countBuyerInSecond;
        for (int time = 0; time < 120; time++) {
            int second = time % 60;
            if ((second <= 30)) {
                countBuyerInSecond = Util.rnd(2) + (second + 10);

            } else {
                countBuyerInSecond = (40 + (30 - second));

            }
            for (int i = countBuyerInSecond; i >0 ; i--) {
                enterBuyers();
            }

            Util.sleep(1000);
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
    private static void enterBuyers() {
        Buyer buyer=new Buyer(++countAllBuyers);
        buyer.start();
        buyers.add(buyer);
    }
}
