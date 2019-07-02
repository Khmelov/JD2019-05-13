package by.it.yaskevich.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Cashier implements Runnable {
    private static final int MAX_COUNT_CASHIERS = 5;

    static final Object monitor = new Object();
    static final List<Cashier> workingCashiers = new ArrayList<>(MAX_COUNT_CASHIERS);

    private int number;

    private String name;

    Cashier(int number) {
        this.name = "Cashier №" + number;
        this.number = number;
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = null;
            synchronized (monitor) {
                if (needWorkingCashier()) {
                    printText("Работают кассы " + workingCashiers + " для покупателей из очереди " + Queue.length());
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
                    buyer.setFlagWait();
                    buyer.notify();
                }
            } else {
                synchronized (monitor) {
                    try {
                        if (!needWorkingCashier()) {
                            monitor.wait();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    private boolean needWorkingCashier() {
        int needCountCashiers = getNeedCountCashiers();
        if (workingCashiers.size() == needCountCashiers) {
            if (!workingCashiers.contains(this)) {
                return false;
            }
        } else if (workingCashiers.size() < needCountCashiers) {
            if (!workingCashiers.contains(this)) {
                workingCashiers.add(this);
            }
        } else if (workingCashiers.size() > needCountCashiers) {
            workingCashiers.remove(this);
            return false;
        }
        return true;
    }

    static int getNeedCountCashiers() {
        int length = Queue.length();
        int needCountCashiers = length / 5 + ((length % 5 > 0) ? 1 : 0);
        return needCountCashiers > 5 ? 5 : needCountCashiers;
    }

    public String getName() {
        return name;
    }

    int getNumber() {
        return number;
    }

    private void printText(String text) {
        Printer.print(text);
    }
}
