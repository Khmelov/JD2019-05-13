package by.it.buymistrov.jd02_01;

import by.it.buymistrov.jd02_02.IUseBacket;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {


    private static Map<String, Integer> backet;
    private static String good;

    private boolean pensioner = false;


    Buyer(int number) {
        super("Buyer №" + number);
        if (number%4==0){
            pensioner=true;
        }
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        for (int i = 0; i < Util.rnd(1, 4); i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        if (!pensioner) {
            System.out.println(this + " enter to the market");
        } else {
            System.out.println(this + " Pensioner enter to the market");
        }
    }

    @Override
    public void chooseGoods() {
        if (!pensioner) {
            System.out.println(this + " start choose goods");
            int timeout = Util.rnd(500, 2000);
            Util.sleep(timeout);
            good = Goods.getRandomGood();
            System.out.println(this + " choose " + good);
            System.out.println(this + " stop choose goods");
        } else {
            System.out.println(this + " Pensioner start choose goods");
            int timeout = Util.rnd(750, 3000);
            Util.sleep(timeout);
            good = Goods.getRandomGood();
            System.out.println(this + " Pensioner choose " + good);
            System.out.println(this + " Pensioner stop choose goods");
        }




    }

    @Override
    public void goOut() {
        if (!pensioner){
            System.out.println(this + " go out from market with " + backet.toString());
        } else {
            System.out.println(this + " Pensioner go out from market with " + backet.toString());
        }


    }


    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        backet = new HashMap<>();
        if (!pensioner) {
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout);
            System.out.println(this + " take backet");
        } else {
            int timeout = Util.rnd(150, 300);
            Util.sleep(timeout);
            System.out.println(this + " Pensioner take backet");
        }


    }

    @Override
    public void putGoodsToBacket() {
        if (!pensioner) {
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout);
            backet.put(good, Goods.getPrice(good));
            System.out.println(this + " put " + good + " to backet ");
        } else {
            int timeout = Util.rnd(150, 300);
            Util.sleep(timeout);
            backet.put(good, Goods.getPrice(good));
            System.out.println(this + " Pensioner put " + good + " to backet ");
        }



    }
}
