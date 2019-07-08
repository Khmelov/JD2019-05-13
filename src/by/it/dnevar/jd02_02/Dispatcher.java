package by.it.dnevar.jd02_02;

public class Dispatcher {

    static final int K_SPEED=100;

    static final int BUYER_STANDART_SPEED = 100;
    static final int BUYER_PENSIONEER_SPEED = 150;

    private static final int PLAN = 100;
    private static int buyerInMarket = 0;
    private static int buyerCounter = 0;
    private static int cashierInWork = 0;


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
    }

    synchronized static void turnOnCashier(){
        cashierInWork++;
    }

    synchronized static void turnOffCashier(){
        cashierInWork--;
    }

    synchronized static int getNumCashierInWork(){
        return cashierInWork;
    }

    synchronized static boolean marketIsOpened(){
        return buyerInMarket+buyerCounter<PLAN;
    }

    synchronized static int getBuyerInMarket(){
        return buyerInMarket;
    }

}
