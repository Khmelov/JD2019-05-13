package by.it.yakovets.jd02_03;


import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioneer;
    private Basket basketOfBuyer;


    private static Semaphore limit = new Semaphore(20);

    public synchronized Basket getBasketOfBuyer() {
        return basketOfBuyer;
    }

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
        start();
    }

    Buyer(int number, boolean pensioneer) {
        super("Buyer №" + number + "(P)");
        this.pensioneer = pensioneer;
        Dispatcher.addBuyer();
        start();
    }


    @Override
    public void run() {
        enterToMarket();
        basketOfBuyer = takeBasket();
        try {
            limit.acquire();

            int countGoods = Helper.rnd(1, 4);
            for (int i = 0; i < countGoods; i++) {
                Good choosedGood = chooseGoods();
                putGoodsToBasket(basketOfBuyer, choosedGood);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            limit.release();
        }
        goToQueue();
        goOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter the market");

    }

    @Override
    public Good chooseGoods() {
        if (!pensioneer) {
            Helper.sleep(Helper.rnd(500, 2000));
        } else {
            int sleeping = (int) (Helper.rnd(500, 2000) * Dispatcher.P_SPEED);
            Helper.sleep(sleeping);
        }
        Good choosedGood = Goods.getRandom();
        System.out.println(this + " choosed " + choosedGood.getName() + " by price " + choosedGood.getPrice());
        return choosedGood;
    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        synchronized (Cashier.monitor) {
            if (Queue.countCashiersPerBuyer()) {
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

    @Override
    public void goOut() {

        Dispatcher.completeBuyer();
        if (Dispatcher.planComplete()) {
            synchronized (Cashier.monitor) {
                Cashier.monitor.notifyAll();
            }
        }
        System.out.println(this + " out from the market");
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

        System.out.println(this + " take backet");
        return new Basket();
    }

    @Override
    public void putGoodsToBasket(Basket basketOfBuyer, Good choosedGood) {
        if (!pensioneer) {
            Helper.sleep(Helper.rnd(100, 200));
        } else {
            Helper.sleep((int) (Helper.rnd(100, 200) * Dispatcher.P_SPEED));
        }
        System.out.println(this + " put " + choosedGood.getName() + " in the backet");
        basketOfBuyer.addToBasket(choosedGood);
    }
}