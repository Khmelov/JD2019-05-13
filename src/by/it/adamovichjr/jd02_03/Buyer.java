package by.it.adamovichjr.jd02_03;

import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuer, IUseBacket {


    Buyer(int number) {
        super("Buyer № " + number);
        if (pensioner) {
            setName("Buyer № " + number + " PENSIONER ");
        }
        Dispetcher.addBuyerInMarket();
        start();

    }

    private static Semaphore maxBuyersInMarket = new Semaphore(20);
    Backet backet;
    boolean pensioner = Time.fromTo(1, 4) == 1;

    @Override
    public void goToQueue() {
        System.out.println(this + " go to queue");

        Queue.addBuyer(this);
        synchronized (Cashier.monitor) {
            if (Queue.checkCashierOfBuyer()) {
                Cashier.monitor.notify();
                Queue.extractCashier();
            }
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    private int valueOfchosesGoods = Time.fromTo(1, 4);
    private int speedPensionerOrNormal = pensioner ? 150 : 100;

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + " Enter to the market");
    }

    @Override
    public String choseGoods() {
        int pause = Time.fromTo(500, 1500) * speedPensionerOrNormal / 100 * Dispetcher.BUYERS_SPEED;
        Time.sleep(pause);
        String choisedGood = Goods.getGood();

        System.out.println(this.getName() + " chose " + choisedGood);
        return choisedGood;
    }

    @Override
    public void run() {
        enterToMarket();
        backet = takeBacket();
        try {
            maxBuyersInMarket.acquire();

        for (int i = 0; i < valueOfchosesGoods; i++) {
            String choisedGood = choseGoods();
            putGoodsToBacet(choisedGood);
        }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            maxBuyersInMarket.release();
        }
        goToQueue();
        goToOut();
    }

    @Override
    public void goToOut() {
        backet.clearBacked();
        Backet.returnBacked(backet);
        Dispetcher.completeBuyerInMarket();
        if (Dispetcher.planComplete()) {
            synchronized (Cashier.monitor) {
                Cashier.monitor.notifyAll();
            }
        }
        System.out.println(this.getName() + " Go home");
    }

    @Override
    public Backet takeBacket() {
        int pause = Time.fromTo(100, 200) * speedPensionerOrNormal / 100 * Dispetcher.BUYERS_SPEED;
        try {
            backet = Backet.takeBackedOfQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Time.sleep(pause);
        System.out.println(this.getName() + " take backet ");
        return backet;
    }

    @Override
    public void putGoodsToBacet(String good) {
        int pause = Time.fromTo(100, 200) * speedPensionerOrNormal / 100 * Dispetcher.BUYERS_SPEED;
        backet.addGoodInBacked(good);
        Time.sleep(pause);
        System.out.println(this.getName() + " put " + good + " to backet");
    }

    @Override
    public String toString() {
        return getName();
    }
}
