package by.it.tbabich.jd02_02;

class Dispatcher {

    static final int K_SPEED = 100;
    static final int PLAN = 100;
    static int buyerInMarket = 0;
    static int buyerCounter = 0;

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
        return (buyerInMarket + buyerCounter) < PLAN;
    }
}
