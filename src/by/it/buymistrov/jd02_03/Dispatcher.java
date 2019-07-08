package by.it.buymistrov.jd02_03;


import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 10;

    private static final int PLAN = 100;

    private static final AtomicInteger buyersInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyersCounter = new AtomicInteger(0);


    static boolean planComplete() {
        return (buyersCounter.get() == PLAN)
                && (buyersInMarket.get() == 0);
    }


    synchronized static void addBuyer() {
        buyersInMarket.getAndIncrement();
    }

    synchronized static void completeBuyer() {
        buyersInMarket.getAndDecrement();
        buyersCounter.getAndIncrement();
    }

    synchronized static boolean marketIsOpened() {
        return buyersInMarket.get() + buyersCounter.get() < PLAN;
    }

    synchronized static int getBuyersCounter() {
        return buyersCounter.get();
    }


    synchronized static int getBuyersInMarket() {
        return buyersInMarket.get();
    }
}

