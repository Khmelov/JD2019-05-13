package by.it.dilkevich.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioneer;
    double slowSpeed;

    void speed(){

        if (pensioneer){
            slowSpeed = 1.5;
        }
        else slowSpeed = 1;
    }

    public Buyer(String name, Boolean isPensioneer) {
        super(name);
        this.pensioneer = isPensioneer;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {

        speed();
        if(pensioneer)
        System.out.println("Покупатель № " + this + " вошел в магазин - пенсирнер");
        else
            System.out.println("Покупатель № " + this + " вошел в магазин");
    }

    @Override
    public void takeBacket() {

        Util.sleep(Util.rnd(100, 200), slowSpeed);
        System.out.println("Покупатель № " + this + " взял корзину");
    }

    String good = "";

    @Override
    public void putGoodsToBacket() {

        Util.sleep(Util.rnd(100, 200), slowSpeed);
        Backet.addGoodToBacket(good, Goods.getCostOfGood(good));
        System.out.println("Покупатель № " + this + " положил " + good + " в корзину");
    }

    @Override
    public void chooseGoods() {

        int countOfGoods = Util.rnd(1,4);
        System.out.println("Покупатель № " + this + " начал выбирать товары");

        for (int i = 0; i < countOfGoods; i++) {

            Util.sleep(Util.rnd(500,2000), slowSpeed);
            good = Goods.getRandomGood();
            System.out.println("Покупатель № " + this + " выбрал " + good);
            putGoodsToBacket();
        }

        System.out.println("Покупатель № " + this + " закончил выбирать товары");
    }

    @Override
    public void goOut() {

        System.out.println("Покупатель № " + this + " покинул магазин");
    }

    @Override
    public String toString() {
        return getName();
    }

}
