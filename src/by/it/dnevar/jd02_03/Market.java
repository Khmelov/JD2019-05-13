package by.it.dnevar.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        System.out.println("Market open");

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.execute(new Cashier(i+1));
            Dispatcher.turnOnCashier();
        }
        executorService.shutdown();

        int countBuyerForName = 0;

        while (Dispatcher.marketIsOpened()) {
            for (int time = 0; time < 120; time++) {
                if ((time % 60 >= 30 && time % 60 < 60 && (threads.size() <= 40 + (30 - time % 60)) || (time % 60 >= 0 && time % 60 < 30))) {
                    int count = Util.rnd(2);
                    for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) {
                        Buyer buyer = new Buyer(++countBuyerForName);
                        buyer.start();
                        threads.add(buyer);
                    }
                }
                Util.sleep(1000);
            }
        }

        for (Thread th : threads) {
            try {
                th.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("Market close");
    }
}
