package by.it.buymistrov.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        int numberBuyer = 0;

        int time = 0;

        List<Thread> threads = new ArrayList<>();

        System.out.println("Market opened");

        for (int i = 0; i < 5; i++) {
            threads.add(new Cashier(i));
        }

        while (Dispatcher.marketIsOpened()) {

            int buyerCount = 0;

            if ((time % 60 >= 0) && ((time % 60 <= 30))) {
                buyerCount = (time % 60 + 10) - Dispatcher.getBuyersInMarket() - 1;
            } else if (time % 60 > 30) {
                buyerCount = (40 + (30 - time % 60)) - Dispatcher.getBuyersInMarket();
            }
            while ((buyerCount > 0) && Dispatcher.marketIsOpened()) {
                threads.add(new Buyer(numberBuyer++));
                buyerCount--;
            }
            Util.sleep(1000);
            time++;
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market closed");

        System.out.println("buyersCount = " + Dispatcher.getBuyersCounter());
    }
}