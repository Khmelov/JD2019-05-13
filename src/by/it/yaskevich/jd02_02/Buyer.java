package by.it.yaskevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private boolean pensioner = false;
    final List<Good> goods = new ArrayList<>();

    Buyer(int number) {
        super("Buyer №" + number);
        pensioner = number % 4 == 0;
        Dispatcher.addBuyer();
        start();
    }

    @Override
    public String toString() {
        return getName() + (isPensioner() ? " (пенсионер)" : "");
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        printText(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        takeBasket();

        printText(this + " начал выбирать товары");
        int countGoods = Utilities.rnd(1, 4);
        for (int i = 0; i < countGoods; i++) {
            Good good = Goods.getRandomGood();
            Utilities.sleep(Utilities.rnd(makeDelay(500), makeDelay(2000)));
            goods.add(good);
            printText(this + " выбрал " + good);
            putGoodsToBasket();
        }
        printText(this + " завершил выбирать(" + countGoods + ")");
    }

    @Override
    public void goToQueue() {
        synchronized (Cashier.monitor){
            Queue.add(this);
            restoreWorkCashiers();
        }
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void restoreWorkCashiers() {
        if (Dispatcher.planComplete()) {
            Cashier.monitor.notifyAll();
        }
        else {
            int needCountCashiers = Cashier.getNeedCountCashiers();
            if (Cashier.cashiers.size() < needCountCashiers) {
                needCountCashiers = needCountCashiers - Cashier.cashiers.size();
                for (int i = 0; i < needCountCashiers; i++) {
                    Cashier.monitor.notify();
                }
            }
        }
    }

    @Override
    public void goOut() {
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor){
            restoreWorkCashiers();
        }
        printText(this + " вышел из магазина");
    }

    @Override
    public void takeBasket() {
        Utilities.sleep(Utilities.rnd(makeDelay(100), makeDelay(200)));
        printText(this + " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        Utilities.sleep(Utilities.rnd(makeDelay(100), makeDelay(200)));
        printText(this + " положил товар в корзину");
    }

    boolean isPensioner() {
        return pensioner;
    }

    private int makeDelay(int value) {
        return (int)(value * (isPensioner() ? 1.5 : 1));
    }

    private void printText(String text) {
        Printer.print(text);
    }

    int getSumTotal() {
        return (goods.size() > 0) ? goods.stream().mapToInt(Good::getPrice).sum() : 0;
    }
}
