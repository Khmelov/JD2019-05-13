package by.it.orlov.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, Backet {

    private List<String> basket = new ArrayList<>();

    List<String> getBasket() {
        return basket;
    }

    private boolean pensioner = Util.getRandom(1, 4) == 1;

    boolean isPensioner() {
        return pensioner;
    }


    private int speed = (pensioner) ? Dispatcher.SPEED_PENSIONER_STANDARD : Dispatcher.SPEED_BUYER_STANDARD;

    Buyer(int number) {
        if (!pensioner) setName("Buyer №" + number);
        else setName("Buyer (pensioner) №" + number);
        Dispatcher.addBuyer();
        start();
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
        System.out.println(this + " enter the market");
        takeBacket();
    }

    @Override
    public void takeBacket() {
        Util.sleep(Util.getRandom(100, 200), speed);
        System.out.println(this + " took the basket");
    }

    @Override // + putGoodsToBacket
    public void chooseGoods() {
        int quantityGoods = Util.getRandom(1, 4);
        String goods;
        for (int i = 0; i < quantityGoods; i++) {
            System.out.println(this + " start choosing the goods");
            Util.sleep(Util.getRandom(500, 2000), speed);
            goods = Goods.getRandomGood();
            basket.add(goods);
            System.out.println(this + " chose " + goods + " price: " + Goods.getPrice(goods));
            putGoodsToBacket();
        }
    }

    @Override
    public void putGoodsToBacket() {
        Util.sleep(Util.getRandom(100, 200), speed);
        System.out.println(this + " put " + basket.get(basket.size() - 1) + " to the basket");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " queued up");
        Queue.addBuyerToQueue(this);
        if ((Queue.cashierInWork() * Cashier.buyersPerCashier < Queue.getQueueSize()) &&
                (Queue.cashierInWork() < 5)) {
            Queue.cashierOpens();
            synchronized (Cashier.monitorCashier) {
                Cashier.monitorCashier.notify();
            }
        }
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " left the market");
        Dispatcher.leftBuyer();
        if (Dispatcher.planComplete()) {
            synchronized (Cashier.monitorCashier) {
                Cashier.monitorCashier.notifyAll();
            }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
