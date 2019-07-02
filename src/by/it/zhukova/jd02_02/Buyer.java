package by.it.zhukova.jd02_02;


import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket {

     Buyer(int number, boolean pensioneer) {
           super("Buyer №" + number);
        this.pensioneer = pensioneer;
         Dispatcher.addBuyer();
     }
    private Good good;
    private boolean pensioneer;
    private List<Good> list = new ArrayList<>();

    public List<Good> getList() {
        return list;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        int count = Util.rnd(1,4);
        System.out.println(this + " start choose goods");
        for (int i = 0; i < count; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        System.out.println(this + " stop choose goods");
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println( this + " enter to the market" );
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
    public void putGoodsToBacket() {
        int timeout = Util.rnd(100, 200);
        if (pensioneer) {
            Util.sleep((int)(timeout*1.5));
        }
        else {
            Util.sleep(timeout);
        }
        Backet.putBacket(list,good);
        System.out.println( this + " put " +good.getName()+" to the basket" );
    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        synchronized (Cashier.monitor) {
            Cashier.monitor.notify();
            if (Queue.size() == 6) {
                Cashier.monitor.notify();
            }
            if (Queue.size() == 11) {
                Cashier.monitor.notify();
            }
            if (Queue.size() == 16) {
                Cashier.monitor.notify();
            }
            if (Queue.size() == 21) {
                Cashier.monitor.notify();
            }
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
}
