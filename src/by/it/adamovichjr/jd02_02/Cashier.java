package by.it.adamovichjr.jd02_02;


public class Cashier extends Thread {

    final static Object monitor = new Object();

    private String name;

    Cashier(int number) {
        name = "Cashier №" + number + " ";
        start();
    }

    @Override
    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public void run() {
        while (!Dispetcher.planComplete()) {
            Buyer buyer = Queue.extract();
            if (buyer != null) {
                System.out.println(this + "started service of " + buyer);
                CashierAparat.printCheck(this,buyer.backet.backetWithGoods);
                int timeout = Time.fromTo(2000,5000);
                Time.sleep(timeout);
                System.out.println(this + "stopped service of " + buyer);
                synchronized (buyer){
                    buyer.notifyAll();
                }
            } else {
                synchronized (monitor){
                    try {
                        System.out.println(this + " start wait");
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
