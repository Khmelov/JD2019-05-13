package by.it.zhukova.jd02_02;


import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBacket {

     Buyer(int number, boolean pensioneer) {
           super("Buyer №" + number);
        this.pensioneer = pensioneer;
         Dispatcher.addBuyer();
     }
    private String good;
    private boolean pensioneer;

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        HashMap<String, Double> basket = new HashMap<>();
        int count = Util.rnd(1,4);
        System.out.println(this + " start choose goods");
        for (int i = 0; i < count; i++) {
            chooseGoods();
            putGoodsToBacket();
            Double price = Goods.getPrice(good);
            basket.put(good, price);
        }
        System.out.println(this + " stop choose goods");
        System.out.print(this + " buy ");
        System.out.println(basket);
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println( this + " enter to the market" );
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);
        if (pensioneer) {
            Util.sleep((int)(timeout*1.5));
        }
        else {
            Util.sleep(timeout);
        }
        good = Goods.getRandomGood();
        System.out.println( this + " choose "+ good );
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
        System.out.println( this + " go out from the market" );
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor){
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100, 200);
        if (pensioneer) {
            Util.sleep((int)(timeout*1.5));
        }
        else {
        Util.sleep(timeout);
        }
        System.out.println( this + " take a basket" );
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.rnd(100, 200);
        if (pensioneer) {
            Util.sleep((int)(timeout*1.5));
        }
        else {
            Util.sleep(timeout);
        }
        System.out.println( this + " put " +good+" to the basket" );
    }
}
