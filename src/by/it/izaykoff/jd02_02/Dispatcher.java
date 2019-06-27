package by.it.izaykoff.jd02_02;

class Dispatcher {

    static final int K_SPEED = 100;

    private static final int PLAN = 100;
    private static int bueyrInMarket = 0;
    private static int bueyrCounter = 0;

    static boolean planComplect(){
        return (bueyrCounter == PLAN && (bueyrInMarket == 0));
    }

    synchronized static void addBuyer(){
        bueyrInMarket++;
    }

    synchronized static void completeBuyer(){
        bueyrInMarket--;
        bueyrCounter++;
    }

    synchronized static boolean marketIsOpened(){
        return bueyrInMarket + bueyrCounter < PLAN;
    }
}
