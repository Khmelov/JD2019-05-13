package by.it.maniuk.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private boolean pensioneer;
    private Semaphore semaphore = new Semaphore(20);
    private List<String> goods = new ArrayList<>();

    private void isPensioner() {
        pensioneer = Util.rnd(4) == 1;
    }

    Buyer( int number)  {
        super("Buyer №" + number);
        Dispatcher.addBuyer();

    }

    @Override
    public void run() {

            isPensioner();
            enterToMarket();

           shopping();
           goToQueue();
           goOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    public void chooseGoods() {
        try {
            semaphore.acquire();
        System.out.println(this + " start choose goods");
        int timeout = Util.rnd(500, 2000, pensioneer);
        Util.sleep(timeout);
        String good = Goods.getRandomGood();
        System.out.println(this + " choose " + good);
        goods.add(good);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void goToQueue() {
        Queue.addBuyer(this);
        synchronized (Cashier.monitor) {
            if (Queue.checkCashierOfBuyer())
            Cashier.monitor.notify();
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
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public void takeBacket() {
            int timeout = Util.rnd(100, 200,pensioneer);
            Util.sleep(timeout);
            System.out.println(this + " took the basket");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.rnd(100, 200,pensioneer);
        Util.sleep(timeout);
        System.out.println(this + " put goods to the basket");


    }
    @Override
    public String toString() {
        return getName();
    }

    private void shopping() {
        for (int i = 0; i < Goods.getRandomQuantityOfGoods(); i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        StringBuilder sb = new StringBuilder();
        for (String good : goods) {
            sb.append(good).append(" ").append(Goods.getCost().get(good)).append("  ");
        }
        Double cost = 0d;
        for (String good : goods) {
            cost += Goods.getCost().get(good);
        }
        cost = Math.floor(cost * 100) / 100;
        sb.append("summa = ").append(cost);
        if (pensioneer) sb.append(" pensionner ");
        System.out.println(this + " stop choose goods: " + sb.toString());
    }

    public List<String> getGoods() {
        return goods;
    }
}