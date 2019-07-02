package by.it.zhukova.jd02_01;

import java.util.*;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    public Buyer(int number, boolean pensioneer) {
        super("Buyer №" + number);

        this.pensioneer = pensioneer;
    }
    private String good;
    private boolean pensioneer;

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        HashMap<String, Double> basket= new HashMap<>();
        int count = Util.rnd(1,4);
        System.out.println(this + " start choose goods");
        for (int i = 0; i < count; i++) {
            chooseGoods();
            putGoodsToBacket();
            Double price = Goods.getPrice(good);
            basket.put(good, price);
        }
        System.out.println(this + " stop choose goods");
        System.out.println(this +" buy "+basket);
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
    public void goOut() {
        System.out.println( this + " go out from the market" );
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
