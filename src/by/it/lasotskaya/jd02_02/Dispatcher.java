package by.it.lasotskaya.jd02_02;

class Dispatcher {

    static final int K_SPEED=100;
    private static final int PLAN = 100;
    private static int buyerInMarket = 0;
    private static int buyerCounter = 0;
    private static int numberBuyer = 0;


    static boolean planComplete() {
        return (buyerCounter == PLAN)
                && (buyerInMarket == 0);
    }

    synchronized static Buyer addBuyer(){
        buyerInMarket++;
        return new Buyer(++numberBuyer);
    }

    synchronized static void completeBuyer(){
        buyerInMarket--;
        buyerCounter++;
    }

    synchronized static boolean allBuyersInShop() {

        return numberBuyer == PLAN;
    }
}
