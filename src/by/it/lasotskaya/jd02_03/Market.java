package by.it.lasotskaya.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    private static final List<Thread> cashiers = new ArrayList<>();
    public static void main(String[] args) {
        System.out.println("Market opened");
        ExecutorService service = Executors.newFixedThreadPool(2);
        for (int i = 1; i <= 2; i++) {
            service.execute(new Cashier(i));
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
        service.shutdown();
        System.out.println("Market closed");
    }
}
