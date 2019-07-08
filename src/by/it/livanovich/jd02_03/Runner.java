package by.it.livanovich.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();
        System.out.println("Магазин открыт");
        ExecutorService service= Executors.newFixedThreadPool(5);
        for (int i = 1; i <3 ; i++) {
            service.execute(new Cashier(i));
        }
        service.shutdown();
        int numberBuyer = 0;
        while (Dispatcher.marketIsOpen()) {
            int count = Rnd.Rnd(2);
            for (int i = 0; i <= count && Dispatcher.marketIsOpen(); i++) {
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
                threads.add(buyer);
            }
        }
        while (!service.isTerminated()){
            Rnd.sleep(100);
        }
        System.out.println("Магазин закрыт");
    }
}
