package by.it.aadamovich.jd02_02;

class Dispatcher {

    static final int SPEED_BUYER_STANDARD = 100;
    static final int SPEED_PENSIONER_STANDARD = 150;
//    static final int SPEED_BUYER_TASKC = 180;
//    static final int SPEED_PENSIONER_TASKC = 270;

    private static final int PLAN = 100;
    private static int buyersInMarket = 0;
    private static int buyersLeftMarket = 0;

    synchronized static void addBuyer() {
        buyersInMarket++;
    }

    synchronized static void leftBuyer() {
        buyersInMarket--;
        buyersLeftMarket++;
    }

    synchronized static boolean marketOpened() {
        return PLAN > buyersInMarket + buyersLeftMarket;
    }

    static boolean planComplete() {
        return (buyersLeftMarket == PLAN)
                && (buyersInMarket == 0);
    }

    static int getBuyersInMarket() {
        return buyersInMarket;
    }
}
