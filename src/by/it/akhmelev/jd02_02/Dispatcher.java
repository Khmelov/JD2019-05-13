package by.it.akhmelev.jd02_02;

class Dispatcher {

    static final int K_SPEED = 100;

    private static final int PLAN = 100;
    private static int buyerInMarket = 0;
    private static int buyerCounter = 0;


    static boolean planComplete() {
        return (buyerCounter == PLAN)
                && (buyerInMarket == 0);
    }

    synchronized static void addBuyer(){
        buyerInMarket++;
    }

    synchronized static void completeBuyer(){
        buyerInMarket--;
        buyerCounter++;
    };

    synchronized static boolean marketIsOpened(){
        return buyerInMarket+buyerCounter<PLAN;
    }

}
