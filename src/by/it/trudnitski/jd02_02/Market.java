package by.it.trudnitski.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        System.out.println("Market opened");

        int numberBuyer = 0;

        for (int i = 0; i < 2 ; i++) {
            Thread thread=new Thread(new Cashier(i));
            threads.add(thread);
            thread.start();

        }
        while (Dispatcher.marketIsOpen()) {
            for (int time = 0; time < 120; time++) {

                int count = Helper.randomeGet(2);
                for (int i = 0; i < count&&Dispatcher.marketIsOpen(); i++) {
                    Buyer buyer = new Buyer(++numberBuyer);
                    buyer.start();


                }
                Helper.sleep(1000);

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
}
