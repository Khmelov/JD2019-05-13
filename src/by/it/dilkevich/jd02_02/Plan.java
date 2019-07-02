package by.it.dilkevich.jd02_02;

public class Plan {

    static int countOfBuyers = 0;
    static int exitBuyers = 0;
    static int klientsPayed = 0;
    static int klientsInQueue = 0;
    static int countActiveCashiers = 0;

    synchronized static void setCountActiveCashiers() {
        ++Plan.countActiveCashiers;
    }
    synchronized static void delCountActiveCashiers() {
        --Plan.countActiveCashiers;
    }

    synchronized static int getKlientsInQueue() {
        return klientsInQueue;
    }
    synchronized static void setKlientInQueue() {
        ++Plan.klientsInQueue;
    }
    synchronized static void delKlientFromQueue() {
        --Plan.klientsInQueue;
    }

    synchronized static int getCountActiveCashiers() {
        return countActiveCashiers;
    }
    synchronized static void addActiveCashier() {
        Plan.countActiveCashiers++;
    }
    synchronized static void delActiveCashier() {
        Plan.countActiveCashiers--;
    }

    synchronized static boolean isPlanComplete(){
       return getKlientsPayed() == Dispatcher.NEDEED_BUYERS_COUNT;
    }


    synchronized static void setKlientsPayed() {
        ++Plan.klientsPayed;
    }


    synchronized static int getKlientsPayed() {
        return klientsPayed;
    }
    synchronized static void setExitBuyers() {
        ++Plan.exitBuyers;
    }

    synchronized static int getExitBuyers() {
        return exitBuyers;
    }

    synchronized static boolean isAnyInMarket(){

        if(getCountOfBuyers() - getExitBuyers() > 0)
            return true;
        else return false;
    }

    synchronized static int getCountOfBuyers() {
        return countOfBuyers;
    }
    synchronized static void setCountOfBuyers() {
        ++Plan.countOfBuyers;
    }
}
