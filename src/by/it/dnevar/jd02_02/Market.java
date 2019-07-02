package by.it.dnevar.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    public static void main(String[] args) {

        List<Thread> threads = new ArrayList<>();

        System.out.println("Market open");

        for (int i = 0; i < 5; i++) {
            Thread thread = new Thread(new Cashier(i+1));
            threads.add(thread);
            thread.start();
        }

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

        System.out.println("Marked close");
    }
}
