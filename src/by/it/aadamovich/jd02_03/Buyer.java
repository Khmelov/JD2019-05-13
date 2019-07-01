package by.it.aadamovich.jd02_03;

import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    static final int BUYERS_SHOPPING_LIMIT = 20;
    static final int BUYERS_QUEUE_LIMIT = 30;

    //every fourth buyer will be pensioner
    private boolean pensioner = Util.getRandom(1, 4) == 1;

    boolean isPensioner() {
        return pensioner;
    }

    // set the difference in timeout for pensioners and control of buyers flow
    private int speed = (pensioner) ? Dispatcher.SPEED_PENSIONER_STANDARD : Dispatcher.SPEED_STANDARD;

    private Basket basket;

    Basket getBasket() {
        return basket;
    }

    private static Semaphore semaphoreShopping = new Semaphore(BUYERS_SHOPPING_LIMIT);
    private static Semaphore semaphoreJoinQueue = new Semaphore(BUYERS_QUEUE_LIMIT);
    private static Semaphore semaphoreBaskets = new Semaphore(Basket.BASKETS_LIMIT);

    private Good good;

    private long timeJoinQueue;

    long getTimeJoinQueue() {
        return timeJoinQueue;
    }

    private boolean flagWait = false;

    void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    Buyer() {
    }

    Buyer(int number) {
        if (!pensioner) setName("Buyer №" + number);
        else setName("Buyer (pensioner) №" + number);
        Dispatcher.addBuyer();
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        try {
            semaphoreBaskets.acquire();
            takeBacket();
            chooseGoods();
            goToQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreBaskets.release();
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter the market");
    }

    @Override
    public void takeBacket() {
        Util.sleep(Util.getRandom(100, 200), speed);
        basket = Basket.takeBasket();
        System.out.println(this + " took the basket " + basket);

    }

    @Override // + putGoodsToBacket
    public void chooseGoods() {
        try {
            semaphoreShopping.acquire();
            int quantityGoods = Util.getRandom(1, 4);
            for (int i = 0; i < quantityGoods; i++) {
                System.out.println(this + " start choosing the goods");
                Util.sleep(Util.getRandom(500, 2000), speed);
                good = Goods.getRandomGood();
                basket.putGoodToBasket(good);
                System.out.println(this + " chose " + good);
                putGoodsToBacket();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreShopping.release();
        }
    }

    @Override
    public void putGoodsToBacket() {
        Util.sleep(Util.getRandom(100, 200), speed);
        System.out.println(this + " put " + good.getName() + " to the basket");
    }

    @Override
    public void goToQueue() {

        try {
            semaphoreJoinQueue.acquire();
            timeJoinQueue = System.nanoTime();

            Queue.addBuyerToQueue(this);
            System.out.println(this + " queued up");
            if ((Queue.cashierInWork() * Cashier.BUYERS_PER_CASHIER - 1 < Queue.getQueueSize()) &&
                    (Queue.cashierInWork() < 5)) {
                Queue.cashierOpens();
                synchronized (Cashier.monitorCashier) {
                    Cashier.monitorCashier.notify();
                }
            }
            flagWait = true;
            synchronized (this) {
                while (flagWait) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphoreJoinQueue.release();
        }
        basket.emptyBasket();
        Basket.returnBasket(basket);
        System.out.println(this + " returned the basket " + basket);
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
