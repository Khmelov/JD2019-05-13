package by.it.livanovich.jd02_02;



public class Buyer extends Thread implements IBuyer, IUseBacket {

    private Good good;



    public Buyer(int number) {
        super("Покупатель № " + number);

        Dispatcher.addBuyer();
    }


    public void run() {
        enterToMarket();
        takeBacket();

        Integer countGoods = Rnd.Rnd(1, 4);
        synchronized (countGoods) {
            for (int i = 1; i <= countGoods; i++) {
                chooseGoods();
                putGoodsToBacket();
            }
        }
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBacket() {
        int timeout = Rnd.Rnd(100, 200);
        Rnd.sleep(timeout / Dispatcher.K_SPEED);
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout = Rnd.Rnd(500, 2000);
        Rnd.sleep(timeout / Dispatcher.K_SPEED);
        good = Goods.getRandomGood();
        System.out.println(this + " выбрал товар " + good);
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Rnd.Rnd(100, 200);
        Rnd.sleep(timeout / Dispatcher.K_SPEED);
        System.out.println(this + " положил в корзину " + good);

    }

    @Override
    public void goToQueue() {
        Queue.addBuyer(this);
        if (Queue.getQueueOfBuyersSize()<=5) {
            synchronized (Cashier.monitor) {
                Cashier.monitor.notify();
            }
        }
        else synchronized (Cashier.monitor) {
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
    public void goOut() {
        System.out.println(this + " вышел из магазина");
        Dispatcher.deductBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public String toString() {
        return getName();
    }

}
