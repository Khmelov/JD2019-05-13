package by.it.yakovets.jd02_01;

class Dispatcher {

    static final int K_SPEED = 100;
    static final double P_SPEED = 1.5;

    static int buyerInMarket = 0;


    synchronized static void addBuyer() {
        buyerInMarket++;
    }

    synchronized static void completeBuyer() {
        buyerInMarket--;
}

}
