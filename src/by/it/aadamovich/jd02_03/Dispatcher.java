package by.it.aadamovich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int SPEED_STANDARD = 100;
    static final int SPEED_PENSIONER_STANDARD = 150;

    private static final int PLAN = 100;
    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersLeftMarket = new AtomicInteger(0);

    static void addBuyer() {
        buyersInMarket.getAndIncrement();
    }

    static void leftBuyer() {
        buyersInMarket.getAndDecrement();
        buyersLeftMarket.getAndIncrement();
    }

    static boolean marketOpened() {
        return PLAN > buyersInMarket.get() + buyersLeftMarket.get();
    }

    static boolean planComplete() {
        return (buyersLeftMarket.get() == PLAN)
                && (buyersInMarket.get() == 0);
    }

    static int getBuyersInMarket() {
        return buyersInMarket.get();
    }

}
