package by.it.guchek.jd02_02;

import java.util.HashMap;

public class Cashier implements Runnable {
    final static Object monitor = new Object();

    private String name;

    Cashier(int number) {
        name = "Cashier №" + number + " ";
    }

    @Override
    //SynchronizationOnLocalVariableOrMethodParameter/
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = Queue.extract();
            if (buyer != null) {
                System.out.println(this + "started service of " + buyer);
                int timeout = RandCount.randFrTo(2000, 5000);
                //final HashMap<Integer, Object> integerObjectHashMap = Bucket.goodsInBacket(buyer.getName());
                //System.out.println(Bucket.goodsInBacket(buyer.getName()).values());
                //Bucket.billGoodsInBacket(buyer.getName());
                RandCount.sleep(timeout);
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
