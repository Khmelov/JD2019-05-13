package by.it.yaskevich.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

class Buyer extends Thread implements IBuyer, IUseBasket {
    private static final int MAX_COUNT_BUYERS_CHOOSING = 20;
    private static final int MIN_COUNT_GOODS = 1;
    private static final int MAX_COUNT_GOODS = 4;

    private static Semaphore queue = new Semaphore(MAX_COUNT_BUYERS_CHOOSING);

    private boolean pensioner = false;

    private List<Good> basket = new ArrayList<>(MAX_COUNT_GOODS);

    private boolean flagWait = false;

    Buyer(int number) {
        super("Buyer №" + number);
        pensioner = Utilities.rnd(1, 4) == 4;
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
        try {
            queue.acquire();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            queue.release();
        }
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
        int countGoods = Utilities.rnd(MIN_COUNT_GOODS, MAX_COUNT_GOODS);
        for (int i = 0; i < countGoods; i++) {
            Utilities.sleep(Utilities.rnd(makeDelay(500), makeDelay(2000)));
            basket.add(Goods.getRandomGood());
            putGoodsToBasket();
        }
        printText(this + " завершил выбирать(" + countGoods + ")");
    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        synchronized (Cashier.monitor) {
            restoreWorkCashiers();
        }
        flagWait = true;
        synchronized (this) {
            while (flagWait) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private void restoreWorkCashiers() {
        if (Dispatcher.planComplete()) {
            Cashier.monitor.notifyAll();
        } else {
            int needCountCashiers = Cashier.getNeedCountCashiers();
            if (Cashier.workingCashiers.size() < needCountCashiers) {
                needCountCashiers = needCountCashiers - Cashier.workingCashiers.size();
                for (int i = 0; i < needCountCashiers; i++) {
                    Cashier.monitor.notify();
                }
            }
        }
    }

    @Override
    public void goOut() {
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor) {
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

    List<Good> getBasket() {
        return basket;
    }

    void setFlagWait() {
        this.flagWait = false;
    }

    private int makeDelay(int value) {
        return (int) (value * (isPensioner() ? 1.5 : 1));
    }

    private void printText(String text) {
        Printer.print(text);
    }

    int getSumTotal() {
        return (basket.size() > 0) ? basket.stream().mapToInt(Good::getPrice).sum() : 0;
    }
}
