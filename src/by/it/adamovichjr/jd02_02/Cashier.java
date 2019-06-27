package by.it.adamovichjr.jd02_02;


public class Cashier extends Thread {

    final static Object monitor = new Object();


    Cashier(int number) {
        setName("Cashier №" + number);
        start();
    }

    @Override

    public void run() {
        while (!Dispetcher.planComplete()) {
            if (Queue.needNewCashier()) {
                Buyer buyer = Queue.extractBuyer();
                System.out.println(this + " started service of " + buyer);
        //        CashierAparat.printCheck(this, buyer.backet.backetWithGoods);
                int timeout = Time.fromTo(2000, 5000);
                Time.sleep(timeout);
                System.out.println(this + "stopped service of " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                synchronized (monitor) {
                    try {
                        Queue.addCashier(this);
                        System.out.println(this + " closed");
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
