package by.it.yakovets.jd02_02;

public class Cashier extends Thread {

    static final Object monitor = new Object();

    public Cashier(int number) {
        setName("Cashier №" + number);
        start();

    }

    @Override
    public void run() {

        while (!Dispatcher.planComplete()) {
            if (Queue.cashiersNeed()){
                Buyer buyer=Queue.extract();
                System.out.println(this + " started service of " + buyer);
                int timeout = Helper.rnd(2000, 5000);
                Helper.sleep(timeout);
                System.out.println("Basket of " + buyer+":");
                buyer.getBasketOfBuyer().printContain();
                System.out.println(this + " stopped service of " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                synchronized (monitor) {
                    try {
                        Queue.addCashier(this);
                        System.out.println(this + " stopped working");
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
        return this.getName();
    }
}