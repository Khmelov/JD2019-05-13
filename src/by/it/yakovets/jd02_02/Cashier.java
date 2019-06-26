package by.it.yakovets.jd02_02;

public class Cashier implements Runnable {
    static final Object monitor = new Object();

    private String name;

    public Cashier(int number) {
        name = "Cashien # " + number;

    }

    @Override
    public void run() {
        Buyer buyer = Queue.extract();
        while (!Dispatcher.planComplete()) {
            if (buyer != null) {
                System.out.println(this + " started service of " + buyer);
                int timeout = Helper.rnd(2000, 5000);
                Helper.sleep(timeout);
                System.out.println(this + " stopped service of " + buyer);
            } else {
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
