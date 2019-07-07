package by.it.yakimovich.jd02_03;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 100;

    private static final int PLAN = 100;
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    final static Semaphore buyerChoosingGoodsSemaphore = new Semaphore(20);


    static boolean planComplete() {
        return (buyerCounter.get() == PLAN)
                && (buyerInMarket.get() == 0);
    }

    synchronized static void addBuyer(){
        buyerInMarket.getAndIncrement(); //b++
    }

    synchronized static void completeBuyer(){
        buyerInMarket.getAndDecrement();
        buyerCounter.getAndIncrement();
    }

    synchronized static boolean marketIsOpened(){
        return buyerInMarket.get()+buyerCounter.get()<PLAN;
    }

}
