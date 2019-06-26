package by.it.akhmelev.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        List<Thread> threads=new ArrayList<>();
        System.out.println("Market opened");
        int numberBuyer=0;

        for (int i = 0; i < 2; i++) {
            Thread thread = new Thread(new Cashier(i));
            threads.add(thread);
            thread.start();
        }

        while (Dispatcher.marketIsOpened()){
            int count=Util.rnd(2);
            for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) {
                Buyer buyer=new Buyer(++numberBuyer);
                buyer.start();
                threads.add(buyer);
            }
            Util.sleep(1000);
        }
        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");
    }
}
