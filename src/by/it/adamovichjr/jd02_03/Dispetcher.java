package by.it.adamovichjr.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispetcher {
    static final int ALL_MARKET_SPEED = 10;
    static final int BUYERS_SPEED = 1;
    static final int NUMBER_OF_CAHIRS = 5;
    static final int BUERS_IN_QUEUE_PER_ONE_CASHIER = 4;

    public static int getCountBuyerInMarket() {
        return countBuyerInMarket.get();
    }

    public static int getCountBuyer() {
        return countBuyer.get();
    }

    private static AtomicInteger countBuyerInMarket = new AtomicInteger(0);
    private static AtomicInteger countBuyer = new AtomicInteger(0);
    private static final int PLAN = 100;



    static void addBuyerInMarket(){
        countBuyerInMarket.getAndIncrement();
    }

    static void completeBuyerInMarket(){
        countBuyerInMarket.getAndDecrement();
        countBuyer.getAndIncrement();
    }
    static boolean planComplete() {
        return (countBuyer.get() == PLAN)
                && (countBuyerInMarket.get() == 0);
    }

    static boolean marketIsOpen(){
        return (countBuyer.get() + countBuyerInMarket.get() < PLAN);
    }

}
