package by.it.tbabich.jd02_03;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Market {

    private static List<Thread> threads = new CopyOnWriteArrayList<>();
    private static int numberBuyer;

    public static void main(String[] args) {
        System.out.println("Market opened");
        numberBuyer = 0;

        for (int i = 1; i < 6; i++) {
            Thread thread = new Thread(new Cashier(i));
            thread.start();
        }

        while (Dispatcher.marketIsOpened()) {
            for (int counter = 0; counter < 120; counter++) {
                int time = 0;
                if (counter > 60) {
                    time = counter % 60;
                } else time = counter;
                if ((time >= 30 && time < 60 && (threads.size() <= 40 + (30 - time)) || (time >= 0 && time < 30))) {
                    visitorLaunch();
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
        }
        System.out.println("Market closed");
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
    }

    private static void visitorLaunch() {
        int count = Util.rnd(2);
        for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) {
            Buyer buyer = new Buyer(++numberBuyer);
            if ((numberBuyer + 1) % 4 == 0) {
                buyer.setPensioneer(true);
            }
            buyer.start();
            threads.add(buyer);
        }
    }

    static void deleteBuyer(Buyer buyer) {
        threads.remove(buyer);
    }
}
