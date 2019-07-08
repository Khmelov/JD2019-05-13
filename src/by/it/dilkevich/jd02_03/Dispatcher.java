package by.it.dilkevich.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED = 100;

    private static final int PLAN = 100;
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger peoplesChosenGoods = new AtomicInteger(0);

    public static int getPeoplesChosenGoods() {
        return peoplesChosenGoods.get();
    }
    public static void addPeoplesChosenGoods(){
        peoplesChosenGoods.incrementAndGet();
    }
    public static void delPeoplesChosenGoods(){
        peoplesChosenGoods.decrementAndGet();
    }


    static boolean planComplete() {
        return (buyerCounter.get() == PLAN)
                && (buyerInMarket.get() == 0);
    }

    static void addBuyer() {
        buyerInMarket.getAndIncrement(); //b++
        //buyerInMarket.incrementAndGet(); //++b
    }

    static void completeBuyer() {
        buyerInMarket.getAndDecrement();
        buyerCounter.getAndIncrement();
    }

    static boolean marketIsOpened() {
        return buyerInMarket.get() + buyerCounter.get() < PLAN;
    }

}
