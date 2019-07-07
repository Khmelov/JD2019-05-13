package by.it.yakovets.jd02_02;

class Dispatcher {

    static final int K_SPEED = 100;
    static final double P_SPEED = 1.5;
    private static final int PLAN = 100;
    static int buyerInMarket = 0;
    static int buyerCounter = 0;
    static int cashierscount=5;


    static boolean planComplete() {
        return (buyerCounter == PLAN)
                && (buyerInMarket == 0);
    }

    synchronized static void addBuyer() {
        buyerInMarket++;

    }

    synchronized static void completeBuyer() {
        buyerInMarket--;
        buyerCounter++;

    }

    synchronized static boolean marketIsOpened() {
        return buyerInMarket + buyerCounter < PLAN;
    }

}