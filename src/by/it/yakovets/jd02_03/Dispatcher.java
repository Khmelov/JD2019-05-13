package by.it.yakovets.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 100;
    static final double P_SPEED = 1.5;
    private static final int PLAN = 100;
    static AtomicInteger buyerInMarket = new AtomicInteger(0);
    static AtomicInteger buyerCounter = new AtomicInteger(0);
    static int cashierscount = 5;


    static boolean planComplete() {
        return (buyerCounter.get() == PLAN)
                && (buyerInMarket.get() == 0);
    }

    static void addBuyer() {
        buyerInMarket.getAndIncrement();

    }

    static void completeBuyer() {
        buyerInMarket.getAndDecrement();
        buyerCounter.getAndIncrement();

    }

    static boolean marketIsOpened() {
        return buyerInMarket.get() + buyerCounter.get() < PLAN;
    }

}