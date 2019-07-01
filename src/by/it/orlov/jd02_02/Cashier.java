package by.it.orlov.jd02_02;

public class Cashier extends Thread {

    static final Object monitorCashier = new Object();
    static final int cashiersMaxLimit = 5;
    static final int buyersPerCashier = 5;

    private int number;

    public Cashier(int number) {
        this.number = number;
        setName("Cashier №" + number);
        start();
    }

    @Override
    public void run() {
        Buyer buyer;
        System.out.println(this + " is opened");
        while (!Dispatcher.planComplete()) {

            if ((Queue.cashierInWork() * buyersPerCashier) >=
                    (Queue.getQueueSize() + buyersPerCashier)) {
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
            } else {
                buyer = Queue.getBuyerFromQueue();
                System.out.println(this + " starts " + buyer + " service");
                Util.sleep(Util.getRandom(2000, 5000), 100);
                System.out.println(this + " completes " + buyer + " service\n"
                        + new Cheque().printCheque(buyer.getBasket(), number));
                synchronized (buyer) {
                    buyer.notify();
                }
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
