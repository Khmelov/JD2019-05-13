package by.it.yaskevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Cashier extends Thread {
    static final Object monitor = new Object();
    static final List<Cashier> cashiers = new ArrayList<>();

    private int number = 0;

    Cashier(int number) {
        super("Cashier №" + number);
        this.number = number;
        start();
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = null;
            synchronized (monitor) {
                if (needWorkCashier()) {
                    printText("Работают кассы " + cashiers + " для покупателей из очереди " + Queue.length());
                    buyer = Queue.extract();
                }
            }
            if (buyer != null) {
                printText(this + " начел обслуживать " + buyer);
                Utilities.sleep(Utilities.rnd(2000, 5000));
                Receipts.add(buyer.getSumTotal());
                Report.print(this, buyer);
                printText(this + " завершил обслуживать " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                synchronized (monitor) {
                    try {
                        if (!needWorkCashier()) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private boolean needWorkCashier() {
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

    static int getNeedCountCashiers() {
        int length = Queue.length();
        int needCountCashiers = length / 5 + ((length % 5 > 0) ? 1 : 0);
        needCountCashiers = needCountCashiers > 5 ? 5 : needCountCashiers;
        return needCountCashiers;
    }

    @Override
    public String toString() {
        return getName();
    }

    private void printText(String text) {
        Printer.print(text);
    }

    int getNumber() {
        return number;
    }
}
