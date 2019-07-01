package by.it.lasotskaya.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    private static final List<Thread> cashiers = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Market opened");
        for (int i = 1; i <= 5; i++) {
            Thread cashier = new Thread(new Cashier(i));
            cashiers.add(cashier);
            cashier.start();
        }
            while (!Dispatcher.allBuyersInShop()){
            Util.sleep(1000);
            int count= Util.rnd(2);
            for (int i = 0; i <= count; i++) {
                if (Dispatcher.allBuyersInShop())
                    break;
                Buyer buyer = Dispatcher.addBuyer();
                buyer.start();

            }
        }
        for (Thread cashier : cashiers) {
            try {
                cashier.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Thread.yield();
        System.out.println("Market closed");
    }
}
