package by.it.yakovets.jd02_02;

public class Cashier implements Runnable {
    static final Object monitor = new Object();

    private String name;

    public Cashier(int number) {
        name = "Cashier №" + number;

    }

    @Override
    public void run() {
        Buyer buyer;
        while (!Dispatcher.planComplete()) {
            buyer = Queue.extract();
            if (buyer != null) {
                System.out.println(this + " started service of " + buyer);
                int timeout = Helper.rnd(2000, 5000);
                Helper.sleep(timeout);
                
                System.out.println(this + " stopped service of " + buyer);
                synchronized (buyer) {
                    buyer.notifyAll();
                }
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
