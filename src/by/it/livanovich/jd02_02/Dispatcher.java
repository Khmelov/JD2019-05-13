package by.it.livanovich.jd02_02;

public class Dispatcher {
    static final int K_SPEED = 100;
    static final int PLAN = 100;
    static int buyerInMarket = 0;
    static int buyerCounter = 0;

    public static boolean planIsDone() {
        return (buyerCounter == PLAN) && (buyerInMarket == 0);
    }

    synchronized static void addBuyer() {
        buyerInMarket++;
    }

    synchronized static void deductBuyer() {
        buyerCounter++;
        buyerInMarket--;
    }

    synchronized static boolean marketIsOpen() {
        return buyerInMarket + buyerCounter < PLAN;
    }
}
