package by.it.buymistrov.jd02_02;


class Dispatcher {
    static final int K_SPEED = 10;

    private static final int PLAN = 100;

    private static int buyersInMarket = 0;
    private static int buyersCounter = 0;


    static boolean planComplete() {
        return (buyersCounter == PLAN)
                && (buyersInMarket == 0);
    }


    synchronized static void addBuyer() {
        buyersInMarket++;
    }

    synchronized static void completeBuyer() {
        buyersInMarket--;
        buyersCounter++;
    }

    synchronized static boolean marketIsOpened() {
        return buyersInMarket + buyersCounter < PLAN;
    }

    synchronized static int getBuyersCounter() {
        return buyersCounter;
    }


    synchronized static int getBuyersInMarket() {
        return buyersInMarket;
    }
}

