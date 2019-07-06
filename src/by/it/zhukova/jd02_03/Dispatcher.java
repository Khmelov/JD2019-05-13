package by.it.zhukova.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {
    static final int K_SPEED=100;
    private static final int PLAN = 100;
    private static final AtomicInteger buyerInMarket = new AtomicInteger();
    private static final AtomicInteger buyerCounter = new AtomicInteger();

    public static AtomicInteger getBuyerInMarket() {
        return buyerInMarket;
    }

    static boolean planComplete() {
        return (buyerCounter.equals(PLAN))
                && (buyerInMarket.equals(0));
    }

    public static int getBuyerCounter() {
        return buyerCounter.get();
    }

    synchronized static void addBuyer(){
        buyerInMarket.getAndIncrement();
    }

    synchronized static void completeBuyer(){
        buyerInMarket.getAndDecrement();
        buyerCounter.getAndIncrement();
    }

    synchronized static boolean marketIsOpened(){
        return buyerInMarket.get()+buyerCounter.get()<PLAN;
    }
}
