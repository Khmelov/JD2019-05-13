package by.it.aadamovich.jd02_03;

public class Cashier implements Runnable {

    static final Object monitorCashier = new Object();
    static final int CASHIERS_MAX_LIMIT = 5;
    static final int BUYERS_PER_CASHIER = 5;

    private String name;
    private int number;

    public Cashier() {
    }

    public Cashier(int number) {
        this.number = number;
        name = "Cashier №" + number;
    }

    @Override
    public void run() {
        Buyer buyer;
        System.out.println(this + " is opened");
        while (!Dispatcher.planComplete()) {

            if ((Queue.cashierInWork() * BUYERS_PER_CASHIER) >
                    (Queue.getQueueSize() + BUYERS_PER_CASHIER)) {
                System.out.println(this + " is closed");
                Queue.cashierCloses();
                synchronized (monitorCashier) {
                    try {
                        monitorCashier.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (!Dispatcher.planComplete())
                    System.out.println(this + " is opened");
            } else if (Queue.getQueueSize() != 0) {
                buyer = Queue.getBuyerFromQueue();
                System.out.println(this + " starts " + buyer + " service");
                Util.sleep(Util.getRandom(2000, 5000));
                System.out.println(this + " completes " + buyer + " service\n"
                        + new Cheque().printCheque(buyer.getBasket(), number));
                synchronized (buyer) {
                    buyer.setFlagWait(false);
                    buyer.notify();
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
