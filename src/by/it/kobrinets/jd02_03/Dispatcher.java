package by.it.kobrinets.jd02_03;

import java.util.concurrent.atomic.AtomicInteger;

class Dispatcher {

    static final int K_SPEED=100;
    private static final AtomicInteger numberBuyer = new AtomicInteger(0);
    private static final AtomicInteger buyerCounter = new AtomicInteger(0);

    private final static int plan = Util.rnd(70,100);


    static boolean planComplete() {
        return buyerCounter.get()>=plan;
    }

    static Buyer addBuyer(){
        return new Buyer(numberBuyer.addAndGet(1));
    }

    static void completeBuyer(){
        buyerCounter.addAndGet(1);    }

    static boolean allBuyersInShop() {

        return numberBuyer.get() == plan;
    }
}