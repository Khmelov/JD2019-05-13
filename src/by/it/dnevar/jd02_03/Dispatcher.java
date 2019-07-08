package by.it.dnevar.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

public class Dispatcher {

    static final int K_SPEED=100;

    static final int BUYER_STANDART_SPEED = 100;
    static final int BUYER_PENSIONEER_SPEED = 150;

    private static final int PLAN = 100;
    private static final AtomicInteger buyerInMarket = new AtomicInteger(0);
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);
    private static final AtomicInteger cashierInWork = new AtomicInteger(0);


    static boolean planComplete() {
        return (buyerCounter.get() == PLAN)
                && (buyerInMarket.get() == 0);
    }

    static void addBuyer(){
        buyerInMarket.getAndIncrement();
    }

    synchronized static void completeBuyer(){
        buyerInMarket.getAndDecrement();
        buyerCounter.getAndIncrement();
    }

    static void turnOnCashier(){
        cashierInWork.getAndIncrement();
    }

    static void turnOffCashier(){
        cashierInWork.getAndDecrement();
    }

    static int getNumCashierInWork(){
        return cashierInWork.get();
    }

    static boolean marketIsOpened(){
        return buyerInMarket.get()+buyerCounter.get()<PLAN;
    }

    static int getBuyerInMarket(){
        return buyerInMarket.get();
    }

}
