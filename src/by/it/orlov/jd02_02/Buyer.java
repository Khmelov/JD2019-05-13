package by.it.orlov.jd02_02;

public class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    @SuppressWarnings("Duplicates") //method chooseGoods() need in jd02_01 too
    public void chooseGoods() {
        System.out.println(this + " start choose goods");
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout);
        Good good = Goods.getRandomGood();
        System.out.println(this + " choose " + good);
        System.out.println(this + " stop choose goods");
    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        synchronized (Cashier.monitor){
            Cashier.monitor.notifyAll();
        }
        synchronized (this){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from the market");
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor){
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}