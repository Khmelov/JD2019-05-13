package by.it.izaykoff.jd02_03;


import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private static Semaphore semaphore = new Semaphore(20);

    private static AtomicInteger buyerInHall = new AtomicInteger(0);

    static void addBuyerInHall() {
        buyerInHall.getAndIncrement();
    }

    static void removeBuyerInHall() {
        buyerInHall.getAndDecrement();
    }


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
        try {
            semaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
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
        addBuyerInHall();
        System.out.println(this + " start choose goods " + "bayer in the hall " + buyerInHall);
        int timeout = Util.rnd(1000, 2000);
        Util.sleep(timeout);
    }

    @Override
    public void goOut() {
        removeBuyerInHall();
        System.out.println(this + " out from the market " + "bayer in the hall " + buyerInHall);
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
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

