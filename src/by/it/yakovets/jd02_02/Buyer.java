package by.it.yakovets.jd02_02;

import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioneer;


    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }

    Buyer(int number, boolean pensioneer) {
        super("Buyer №" + number + "(P)");
        this.pensioneer = pensioneer;
        Dispatcher.addBuyer();
    }


    @Override
    public void run() {
        enterToMarket();
        Basket basket = takeBasket();
        int countGoods = Helper.rnd(1, 4);
        for (int i = 0; i < countGoods; i++) {
            chooseGoods();
            putGoodsToBasket();
        }
        goToQueue();
        goOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter the market");

    }

    @Override
    public void chooseGoods() {
        if (!pensioneer) {
            Helper.sleep(Helper.rnd(500, 2000));
        } else {
            int sleeping = (int) (Helper.rnd(500, 2000) * Dispatcher.P_SPEED);
            Helper.sleep(sleeping);
        }
        String good = Goods.getRandom();
        System.out.println(this + " choose " + good);

    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from the market");
        Dispatcher.completeBuyer();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public Basket takeBasket() {
        if (!pensioneer) {
            Helper.sleep(Helper.rnd(100, 200));
        } else {
            Helper.sleep((int) (Helper.rnd(100, 200) * Dispatcher.P_SPEED));
        }
        Basket basket = new Basket();
        System.out.println(this + " take backet");
        return basket;
    }

    @Override
    public void putGoodsToBasket() {
        if (!pensioneer) {
            Helper.sleep(Helper.rnd(100, 200));
        } else {
            Helper.sleep((int) (Helper.rnd(100, 200) * Dispatcher.P_SPEED));
        }
//        basket.addToBasket(good);
        System.out.println(this + " put the good in the backet");

    }
}