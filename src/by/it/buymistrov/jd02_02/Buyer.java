package by.it.buymistrov.jd02_02;


import java.util.ArrayList;
import java.util.List;

class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioner = false;


    boolean isPensioner() {
        return pensioner;
    }

    List<String> getGood() {

        return good;
    }

    private final List<String> good = new ArrayList<>();

    Buyer(int number) {
        super("Buyer №" + number);
        if (number % 4 == 0) {
            pensioner = true;
        }
        Dispatcher.addBuyer();
        start();
//        pensioner = !pensioner;
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
        System.out.println(this + " enter to the market");
    }

    @Override
    public void chooseGoods() {
        takeBacket();
        System.out.println(this + " start choose goods");
        for (int i = 0; i < Util.rnd(1, 4); i++) {

            String g = Goods.getRandomGood();
            if (!pensioner) {
                Util.sleep(Util.rnd(500, 2000));
            } else {
                Util.sleep(Util.rnd(750, 3000));
            }
            good.add(g);
            System.out.println(this + " choose " + good);
            putGoodsToBacket();
        }
        System.out.println(this + " stop choose goods");
    }

    @Override
    public void goToQueue() {
        synchronized (Cashier.monitor) {
            Queue.add(this);
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
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
        System.out.println(this + " out from the market");
    }

    @Override
    public void takeBacket() {
        if (!pensioner) {
            Util.sleep(Util.rnd(100, 200));
        } else {
            Util.sleep(Util.rnd(150, 300));
        }
        System.out.println(this + " take backet");
    }

    @Override
    public void putGoodsToBacket() {
        if (!pensioner) {
            Util.sleep(Util.rnd(100, 200));
        } else {
            Util.sleep(Util.rnd(150, 300));
        }
        System.out.println(this + " put good to backet");
    }

    @Override
    public String toString() {
        if (pensioner) {
            return getName() + " Pensioner";

        } else {
            return getName();

        }

    }
}