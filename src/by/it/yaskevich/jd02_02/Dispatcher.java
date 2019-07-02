package by.it.yaskevich.jd02_02;

class Dispatcher {

    private static final int PLAN = 100;

    private static int buyersInMarket = 0;
    private static int buyersCounter = 0;

    synchronized static void addBuyer(){
        buyersInMarket++;
    }

    synchronized static void completeBuyer(){
        buyersInMarket--;
        buyersCounter++;
    }

    static boolean planComplete() {
        return (buyersCounter == PLAN) && (buyersInMarket == 0);
    }

    synchronized static boolean marketIsOpened(){
        return buyersInMarket + buyersCounter < PLAN;
    }

    synchronized static int getBuyersCounter() {
        return buyersCounter;
    }

    synchronized static int getBuyersInMarket() {
        return buyersInMarket;
    }

}
