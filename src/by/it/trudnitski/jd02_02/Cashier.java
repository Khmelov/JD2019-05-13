package by.it.trudnitski.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Cashier extends Thread {
    static final Object monitor = new Object();
    private String name;
    private final List<Cashier> cashiers = new ArrayList<>();


    public Cashier(int number) {
        name = "Cashier № " + number + " ";
    }

    @Override
    public void run() {
        System.out.println(this + " is opened");
        while (!Dispatcher.planComplete()) {
            Buyer buyer=null;
            synchronized (monitor) {
                if (needCashier()) {
                    System.out.println("Cashier" + cashiers + "working for buyer from Queue" + Queue.lenght());
                    buyer = Queue.extract();
                }
            }
            if (buyer != null) {
                System.out.println(this + " starts " + buyer + " service");
                Helper.sleep(Helper.randomeGet(2000, 5000));
                System.out.println(this + " completes " + buyer + " service");
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

    private boolean needCashier() {
        int needCountCashiers = getNeedCountCashiers();
        if (cashiers.size() < needCountCashiers) {
            if (!cashiers.contains(this)) {
                cashiers.add(this);
            }
        } else if (cashiers.size() > needCountCashiers) {
            cashiers.remove(this);
            return false;
        } else {
            if (!cashiers.contains(this)) {
                return false;
            }
        }
        return true;
    }

    private static int getNeedCountCashiers() {
        int length = Queue.lenght();
        int needCountCashiers = length / 5 + ((length % 5 > 0) ? 1 : 0);
        needCountCashiers = needCountCashiers > 5 ? 5 : needCountCashiers;
        return needCountCashiers;
    }


    @Override
    public String toString() {
        return name;
    }
}
