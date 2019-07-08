package by.it.yakovets.jd02_03;

public class Cashier implements Runnable {

    static final Object monitor = new Object();

    private String name;
    public Cashier(int number) {
        name="Cashier №" + number;


    }

    @Override
    public void run() {

        while (!Dispatcher.planComplete()) {
            if (Queue.cashiersNeed()) {
                Buyer buyer = Queue.extract();
                System.out.println(this + " started service of " + buyer);
                System.out.println("Basket of " + buyer + ":");
                buyer.getBasketOfBuyer().printContain();
                int timeout = Helper.rnd(2000, 5000);
                Helper.sleep(timeout);
                System.out.println(this + " stopped service of " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                synchronized (monitor) {
                    try {
                        Queue.addCashier(this);
                        System.out.println(this + " isn't working");
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
        return this.name;
    }
}