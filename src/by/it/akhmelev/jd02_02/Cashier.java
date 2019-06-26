package by.it.akhmelev.jd02_02;

public class Cashier implements Runnable {

    final static Object monitor = new Object();

    private String name;

    Cashier(int number) {
        name = "Cashier №" + number + " ";
    }

    @Override
    @SuppressWarnings("all")
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = Queue.extract();
            if (buyer != null) {
                System.out.println(this + "started service of " + buyer);
                int timeout = Util.rnd(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + "stopped service of " + buyer);
                synchronized (buyer){
                    buyer.notifyAll();
                }
            } else {
                synchronized (monitor){
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
