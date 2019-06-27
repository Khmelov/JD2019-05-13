package by.it.adamovichjr.jd02_02;

class Dispetcher {
    static final int ALL_MARKET_SPEED = 10;
    static final int BUYERS_SPEED = 1;
    static final int numberOfCashier = 5;
    static int countBuyerInMarket = 0;
    private static int countBuyer = 0;
    private static final int PLAN = 100;

    synchronized static void addBuyerInMarket(){
        countBuyerInMarket++;
    }

    synchronized static void completeBuyerInMarket(){
        countBuyerInMarket--;
        countBuyer++;
    }
    static boolean planComplete() {
        return (countBuyer == PLAN)
                && (countBuyerInMarket == 0);
    }

    static boolean marketIsOpen(){
        return (countBuyer + countBuyerInMarket < PLAN);
    }

}
