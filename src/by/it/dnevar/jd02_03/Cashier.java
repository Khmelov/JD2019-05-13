package by.it.dnevar.jd02_03;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cashier implements Runnable {

    final static Object monitor = new Object();

    private String name;

    Cashier(int number) {
        name = "Cashier " + number;
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = Queue.extract();
            if (buyer != null) {
                Dispatcher.turnOnCashier();
                System.out.println(this + " started service of " + buyer);
                int timeout = Util.rnd(2000, 5000);
                Util.sleep(timeout);
                synchronized (buyer) {
                    HashMap<String, Double> buyerBacket = buyer.getBacket();
                    Set<String> keys = buyerBacket.keySet();
                    Iterator<String> iterator = keys.iterator();
                    Double sum = 0.0;
                    while (iterator.hasNext()) {
                        String good = iterator.next();
                        Double price = buyerBacket.get(good);
                        sum += price;
                        System.out.println(buyer + " buy " + good + " at price " + price + " byn");
                    }
                    System.out.println(buyer+ " total " + sum + " byn");
                }
                System.out.println(this + " stopped service of " + buyer);
                synchronized (buyer) {
                    buyer.notifyAll();
                }


            } else {
                Dispatcher.turnOffCashier();
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
