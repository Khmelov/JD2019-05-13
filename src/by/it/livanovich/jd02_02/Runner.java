package by.it.livanovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        System.out.println("Магазин открыт");
        for (int i = 1; i <6 ; i++) {
            Thread cashier=new Thread(new Cashier(i));
            cashier.start();
            threads.add(cashier);
        }
        int numberBuyer = 0;
        while (Dispatcher.marketIsOpen()) {
            int count = Rnd.Rnd(2);
            for (int i = 0; i <= count && Dispatcher.marketIsOpen(); i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
                threads.add(buyer);
            }
        }
        for (Thread thread : threads) {
            thread.join();
        }
        System.out.println("Магазин закрыт");
    }
}
