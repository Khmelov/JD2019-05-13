package by.it.lasotskaya.jd02_03;

import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private static Semaphore limitBuyersChooseGoods = new Semaphore(20);
    private String name;
    Buyer(int number) { name = " Buyer №" + number; }

    @Override
    public String toString() {
        return name + " ";
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
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
            System.out.println(this + " going: " + Buyer.limitBuyersChooseGoods.availablePermits());
            limitBuyersChooseGoods.acquire();
            System.out.println(" go shopping: " + Buyer.limitBuyersChooseGoods.availablePermits());
            Util.sleep(Util.rnd(500, 2000));
            System.out.println(this + " choose goods");
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }finally {
            limitBuyersChooseGoods.release();
    }
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from the market");
        Dispatcher.completeBuyer();
    }

    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        System.out.println(this + " choose basket");
    }

    @Override
    public void putGoodsToBacket() {
        double totalCost = 0;
        int r = Util.rnd(1, 4);
        for (int i = 1; i <= r; i++) {
            Util.sleep(Util.rnd(100, 200));
            int w = Util.rnd(0, Goods.pairs.size() - 1);
            String key = Goods.pairs.get(w).getKey();
            Double value = Goods.pairs.get(w).getValue();
            totalCost += value;

            System.out.println(this + " Put goods " + key + " " + value + " to basket");
        }
        System.out.println(this + " General sum: " + Math.round(totalCost*100.0)/100.0);

    }

    @Override
    public void goToQueue() {
        System.out.println(this + " go to queue");
        Queue.add(this);

        synchronized (this) {
            while (Queue.buyerInQueue(this)) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
