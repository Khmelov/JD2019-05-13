package by.it.trudnitski.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private Semaphore semaphore = new Semaphore(20);
    private static List<Double> sum = new ArrayList<>();


    public Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }


    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQeue();
        goOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " Enter to the market ");

    }

    @Override
    public void chooseGoods() {
        try {
            semaphore.acquire();
        } catch (Exception e) {
            e.printStackTrace();
        }
        double res = 0;
        int randome = Helper.randomeGet(1, 4);

        takeBacket();

        System.out.println(this + " Start choose goods ");

        for (int i = 0; i < randome; i++) {
            int timeOut = Helper.randomeGet(500, 2000);
            Helper.sleep(timeOut);
            Good goods = Goods.getRandomGood();
            System.out.println(this + " choose " + goods);
            sum.add(goods.getPrice());
            res += goods.getPrice();
            putGoodsToBacket();
        }

        System.out.println(this + " All goods cost " + res + " byn ");
    }

    @Override
    public void goOut() {
        System.out.println(this + "  out from the market");
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notify();
        }

    }

    @Override
    public void goToQeue() {
        Queue.add(this);
        semaphore.release();

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
        System.out.println(this + "  put to the basket");

    }

}

