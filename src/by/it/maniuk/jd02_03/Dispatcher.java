package by.it.maniuk.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 100;

    private static final int PLAN = 100;
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final int cashierNumber = 5;

    static boolean planComplete() {
        return (buyerCounter.get() == PLAN)
                && (buyerInMarket.get() == 0);
    }

    static void addBuyer(){
        buyerInMarket.getAndIncrement();
    }

    static void completeBuyer(){
        buyerInMarket.getAndDecrement();
        buyerCounter.getAndIncrement();
    }

     static boolean marketIsOpened(){
        return  buyerInMarket.get() + buyerCounter.get() < PLAN;}

    static int getCashierNumber() {
        return cashierNumber;
    }
}
