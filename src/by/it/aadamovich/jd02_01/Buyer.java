package by.it.aadamovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private int speed;

    private List<String> goods = new ArrayList<>();

    Buyer(int number) {
        boolean pensioner = Util.getRandom(1, 4) == 1;  //every fourth buyer will be pensioner
//        speed = (pensioner) ? 150 : 100;                // standard (TaskB)
        speed = (pensioner) ? 240 : 160;                // long timeout (TaskC)
        setName("Buyer №" + number);
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        int quantityGoods = Util.getRandom(1, 4);
        for (int i = 0; i < quantityGoods; i++) {
            chooseGoods();
        }
        goOut();
    }

    @Override // + takeBacket
    public void enterToMarket() {
        System.out.println(this + " enter the market");
        takeBacket();
    }

    @Override
    public void takeBacket() {
        Util.sleep(Util.getRandom(100, 200), speed);
        System.out.println(this + " took the basket");
    }

    @Override // + putGoodsToBacket
    public void chooseGoods() {
        System.out.println(this + " start choosing the goods");
        Util.sleep(Util.getRandom(500, 2000), speed);
        goods.add(Util.getRandomGood());
        System.out.println(this + " chose " + goods.get(goods.size() - 1));
        putGoodsToBacket();
    }

    @Override
    public void putGoodsToBacket() {
        Util.sleep(Util.getRandom(100, 200), speed);
        System.out.println(this + " put " + goods.get(goods.size() - 1) + " to the basket");
    }

    @Override
    public void goOut() {
        System.out.println(this + " left the market");
        Runner.countBuyersInMarket--;
    }

    @Override
    public String toString() {
        return getName();
    }
}
