package by.it.trudnitski.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {


    public Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }

    private Semaphore semaphore = new Semaphore(20);

    private static List<Good> goods = new ArrayList<>();


    @Override
    public void run() {
        try {
            semaphore.acquire();
            enterToMarket();
            takeBacket();
            chooseGoods();
            goToQeue();
            goOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + "enter to the market");

    }

    @Override
    public void chooseGoods() {

        int randome = Helper.randomeGet(1, 4);
        double sum = 0;

        for (int i = 0; i < randome; i++) {
            int timeOut = Helper.randomeGet(500, 2000);
            Helper.sleep(timeOut);
            Good goods = Goods.getRandomGood();
            System.out.println(this + " choose " + goods);
            sum += goods.getPrice();
        }
        putGoodsToBacket();
        System.out.println(this + " All goods cost " + sum + "byn");
    }

    @Override
    public void goOut() {
        System.out.println(this + "  out from the market");
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }

    }

    @Override
    public void goToQeue() {
        Queue.add(this);
        synchronized (Cashier.monitor) {
            Cashier.monitor.notify();
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
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.randomeGet(100, 200));
        System.out.println(this + " took the basket");

    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.randomeGet(100, 200));
        System.out.println(this + "  put goods to the basket");

    }

    double getSumTotal() {
        return (goods.size() > 0) ? goods.stream().mapToDouble(Good::getPrice).sum() : 0;
    }
}

