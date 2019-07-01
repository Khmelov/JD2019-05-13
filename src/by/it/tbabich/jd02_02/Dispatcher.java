package by.it.tbabich.jd02_02;

class Dispatcher {

    static final int K_SPEED = 1;
    final static Object console = new Object();

    private static final int PLAN = 100;
    private static int buyerInMarket = 0;
    private static int buyerCounter = 0;
    private static int activeCashiers = 0;
    private static double total = 0;

    synchronized static double getTotal() {
        return total;
    }

    synchronized static void addTotal(double value) {
        total += value;
    }

    static boolean planComplete() {
        return (buyerCounter == PLAN)
                && (buyerInMarket == 0);
    }

    synchronized static void addBuyer() {
        buyerInMarket++;
    }

    synchronized static void completeBuyer() {
        buyerInMarket--;
        buyerCounter++;
    }

    synchronized static void cashierOpen() {
        activeCashiers++;
    }

    synchronized static void cashierClose() {
        activeCashiers--;
    }

    synchronized static boolean marketIsOpened() {
        return buyerInMarket + buyerCounter < PLAN;
    }

    synchronized static void checkCashiers() {
        int queueSize = Queue.getQueueSize() + PensionersQueue.getQueueSize();
        int checkLenght = queueSize % 5 == 0 ? queueSize / 5 : queueSize / 5 + 1;
        if (checkLenght > activeCashiers) {
            for (int i = 0; i < checkLenght - activeCashiers; i++) {
                synchronized (Cashier.monitor) {
                    Cashier.monitor.notify();
                }
                Dispatcher.cashierOpen();
            }
        }
    }
}
