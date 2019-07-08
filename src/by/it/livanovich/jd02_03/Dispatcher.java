package by.it.livanovich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static final int K_SPEED = 100;
    static final int PLAN = 100;
    static final AtomicInteger buyerInMarket = new AtomicInteger(0);
    static final AtomicInteger buyerCounter = new AtomicInteger(0);

    public static boolean planIsDone() {
        return (buyerCounter.get() == PLAN) && (buyerInMarket.get() == 0);
    }

    static void addBuyer() {
        buyerInMarket.getAndIncrement();
    }

    static void deductBuyer() {
        buyerCounter.getAndIncrement();
        buyerInMarket.getAndDecrement();
    }

    static boolean marketIsOpen() {
        return buyerInMarket.get() + buyerCounter.get() < PLAN;
    }
}
