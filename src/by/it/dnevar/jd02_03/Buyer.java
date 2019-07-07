package by.it.dnevar.jd02_03;

import java.util.HashMap;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private HashMap<String,Double> backet= new HashMap<>();

    private boolean pensioneer = Util.rnd(1,4)==1;
    private int speed;



    Buyer(int number){
        if(!pensioneer) {
            setName("Buyer " + number);
            speed = Dispatcher.BUYER_STANDART_SPEED;
        }else{
            setName("Buyer(pensioneer) " + number);
            speed = Dispatcher.BUYER_PENSIONEER_SPEED;
        }
        Dispatcher.addBuyer();
    }

    @Override
    public void run(){
        enterToMarket();
        takeBacket();
        chooseGood();
        putGoodsToBacket();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to marker");
    }

    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100,200);
        Util.sleep(timeout);
        System.out.println(this +" take backet");
    }

    @Override
    public void chooseGood() {
        System.out.println(this+" start choose goods");
        int timeout = Util.rnd(5*speed,20*speed);
        Util.sleep(timeout);
        int countGoods = Util.rnd(1,4);
        for (int i = 0; i < countGoods; i++) {
            String good = Goods.getRandomGood();
            Double price = Goods.getGoodPrice(good);
            System.out.println(this+" get "+good);
            backet.put(good,price);
        }
        System.out.println(this+" stop choose goods");
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.rnd(1*speed,2*speed);
        Util.sleep(timeout);
        System.out.println(this +" put goods to backet");
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
        System.out.println(this+" go out");
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor){
            Cashier.monitor.notifyAll();
        }
    }

    public HashMap<String,Double> getBacket(){
        return backet;
    }

    @Override
    public String toString(){
        return getName();
    }

}
