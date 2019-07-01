package by.it.tbabich.jd02_03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 1;
    final static Object console = new Object();
    final static Semaphore buyerInMarketSemaphore = new Semaphore(20);
    final static Semaphore backetSemaphore = new Semaphore(50);

    private static final int PLAN = 100;
    private static AtomicInteger buyerInMarket = new AtomicInteger(0);
    private static AtomicInteger buyerCounter = new AtomicInteger(0);
    private static AtomicInteger activeCashiers = new AtomicInteger(0);
    private static double total = 0;

    synchronized static double getTotal() {
        return total;
    }

    synchronized static void addTotal(double value) {
        total += value;
    }

    static boolean planComplete() {
        return (buyerCounter.get() == PLAN)
                && (buyerInMarket.get() == 0);
    }

    static void addBuyer() {
        buyerInMarket.incrementAndGet();
    }

    static void completeBuyer() {
        buyerInMarket.decrementAndGet();
        buyerCounter.incrementAndGet();
    }

    static void cashierOpen() {
        activeCashiers.incrementAndGet();
    }

    static void cashierClose() {
        activeCashiers.decrementAndGet();
    }

    static boolean marketIsOpened() {
        return buyerInMarket.get() + buyerCounter.get() < PLAN;
    }

    static void checkCashiers() {
        int queueSize = Queue.getQueueSize() + PensionersQueue.getQueueSize();
        if ((queueSize / 5 + 1) > activeCashiers.get()) {
            for (int i = 0; i < (queueSize / 5 + 1) - activeCashiers.get(); i++) {
                synchronized (Cashier.monitor) {
                    Cashier.monitor.notify();
                }
                Dispatcher.cashierOpen();
            }
        }
    }
}
