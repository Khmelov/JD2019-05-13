package by.it.yakimovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer,IBacket {
    private boolean pensioneer;

    Buyer(int number) {
        super("Buyer №" + number);
        int a = (number % 4);
        pensioneer = a == 0;
    }

    public List<Good> list = new ArrayList<>();

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    public void chooseGoods() {
        if (pensioneer) {
            System.out.println(this + " is pensioneer");
        }
        System.out.println(this + " start choose goods");
        for (int i = 0; i < Util.rnd(1, 4); i++) {
            int timeout = Util.rnd(500, 2000);
            if (!pensioneer) {
                Util.sleep(timeout);
                Good good = Goods.getRandomGood();
                System.out.println(this + " choose " + good);
                list.add(good);
            } else Util.sleep((int) (timeout * 1.5));
            Good good = Goods.getRandomGood();
            System.out.println(this + " choose " + good);
            list.add(good);
        }
        System.out.println(this + " stop choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from the market");
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        if (!pensioneer) {
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout);
            System.out.println(this + " took backet");
        } else {
            int timeout = Util.rnd(150, 300);
            Util.sleep(timeout);
            System.out.println(this + " took backet");
        }

    }

    @Override
    public void putGoodsToBacket() {
        if (!pensioneer) {
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout);
            String result = list.toString().replace("[", "").replace("]", "");
            System.out.println(this + " put in backet " + result);
        } else {
            int timeout = Util.rnd(150, 300);
            Util.sleep(timeout);
            String result = list.toString().replace("[", "").replace("]", "");
            System.out.println(this + " put in backet " + result);
        }
    }
}