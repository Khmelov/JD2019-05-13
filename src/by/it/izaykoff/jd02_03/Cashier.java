package by.it.izaykoff.jd02_03;

import java.util.LinkedList;
import java.util.List;

class Cashier implements Runnable {
    final static Object monitor = new Object();

    private String name;

    private static List<Cashier> cashiersAtWork = new LinkedList<>();

    Cashier(int number) {
        name = "Cashier №" + number + " ";
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = null;
            synchronized (monitor) {
                if (workCashier()) {
                    System.out.println("cashier work " + cashiersAtWork + " buyers in queue " + Queue.length());
                    buyer = Queue.extract();
                }
            }
            if (buyer != null) {
                service(buyer);
                synchronized (buyer) {
                    buyer.setFlagWait();
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

    private void service(Buyer buyer) {
        System.out.println(this + "started service of " + buyer);
        int timeout = Util.rnd(2000, 5000);
        Util.sleep(timeout);
        double total = buyer.getTotal();
        System.out.println(this + "check goods " + buyer + " goods" + " total: " + total);
        System.out.println(this + "stopped service of " + buyer);
    }

    private boolean workCashier() {
        int workCountCashiers = countCashiers();
        if (cashiersAtWork.size() < workCountCashiers) {
            if (!cashiersAtWork.contains(this)) {
                cashiersAtWork.add(this);
            }
        } else if (cashiersAtWork.size() > workCountCashiers) {
            cashiersAtWork.remove(this);
            return false;
        } else {
            return cashiersAtWork.contains(this);
        }
        return true;
    }

    private static int countCashiers() {
        int length = Queue.length();
        int countCashiers = length / 5 + ((length % 5 > 0) ? 1 : 0);
        countCashiers = countCashiers > 5 ? 5 : countCashiers;
        return countCashiers;
    }

    @Override
    public String toString() {
        return name;
    }
}
