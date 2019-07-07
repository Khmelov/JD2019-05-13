package by.it.izaykoff.jd02_03;


import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBasket {


    private static Semaphore semaphore = new Semaphore(20);


    public Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }

    void setFlagWait() {
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        putGoodsToBasket();
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
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(this + " start choose goods ");
        int timeout = Util.rnd(1000, 2000);
        Util.sleep(timeout);
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from the market ");
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        semaphore.release();
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
    public void takeBasket() {
        System.out.println(this + " took the basket");
    }

    private Double total;

    Double getTotal() {
        return total;
    }

    private void setTotal(Double total) {
        this.total = total;
    }

    @Override
    public void putGoodsToBasket() {
        int count;
        double price = 0;
        for (count = 1; count < 5; count++) {
            Good good = Goods.getRandomGood();
            price += good.getPrice();
            System.out.println(this + " choose " + count + " " + good + " put in the basket");
        }
        setTotal(price);
        System.out.println(this + " stop choose goods ");
    }

    @Override
    public String toString() {
        return getName();
    }
}

