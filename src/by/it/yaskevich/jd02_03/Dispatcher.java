package by.it.yaskevich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {
    private static final int PLAN = 100;

    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersCounter = new AtomicInteger(0);

    static void addBuyer() {
        buyersInMarket.getAndIncrement();
    }

    static void completeBuyer() {
        buyersInMarket.getAndDecrement();
        buyersCounter.getAndIncrement();
    }

    static boolean planComplete() {
        return (buyersCounter.get() == PLAN) && (buyersInMarket.get() == 0);
    }

    static boolean marketIsOpened() {
        return buyersInMarket.get() + buyersCounter.get() < PLAN;
    }

    static int getBuyersCounter() {
        return buyersCounter.get();
    }

    static int getBuyersInMarket() {
        return buyersInMarket.get();
    }
}
