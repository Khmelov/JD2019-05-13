package by.it.kobrinets.jd02_02;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private String name;

    Buyer(int number) {
        name = " Buyer №" + number;
    }

    @Override
    public String toString() {
        return name + " ";
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
        Util.sleep(Util.rnd(500, 2000));
        System.out.println(this + " start choosing goods");
    }

    @Override
    public void takeBasket() {
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        System.out.println(this + " took the basket");
    }

    @Override
    public void putGoodsToBasket() {
        double totalCost = 0;
        int r = Util.rnd(1, 4);
        for (int i = 1; i <= r; i++) {
            Util.sleep(Util.rnd(100, 200));
            int w = Util.rnd(0, Goods.pairs.size() - 1);
            String key = Goods.pairs.get(w).getKey();
            Double value = Goods.pairs.get(w).getValue();
            totalCost += value;
            System.out.println(this + " put goods " + key + " " + value + " to the basket");
        }
        System.out.println(this + " total cost: " + Math.round(totalCost * 100.0) / 100.0);

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
    @Override
    public void goOut() {
        System.out.println(this + " left the market");
        Dispatcher.completeBuyer();
    }
}