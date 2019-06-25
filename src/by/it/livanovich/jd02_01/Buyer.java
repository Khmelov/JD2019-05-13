package by.it.livanovich.jd02_01;

import static by.it.livanovich.jd02_01.Basket.basket;

public class Buyer extends Thread implements IBuyer,IUseBacket{
    static final int K_SPEED=10;
    int number;
    String good;

    public Buyer (int number){
        super("Покупатель № "+number);
    }

    public void run () {
        enterToMarket();
        takeBacket();
        int countGoods=Rnd.Rnd(1,4);
        for (int i = 1; i <=countGoods ; i++) {
            chooseGoods();
            putGoodsToBacket();
            Basket.putInBasket(good);
        }
        Basket.Basket(getName());
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+" вошел в магазин");
    }

    @Override
    public void takeBacket() {
        int timeout=Rnd.Rnd(100,200);
        Rnd.sleep(timeout/K_SPEED);
        System.out.println(this+" взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout=Rnd.Rnd(500,2000);
        Rnd.sleep(timeout/K_SPEED);
        good=Goods.getRandomGood();
        System.out.println(this+" выбрал товар "+good);
    }

    @Override
    public void putGoodsToBacket() {
        int timeout=Rnd.Rnd(100,200);
        Rnd.sleep(timeout/K_SPEED);
        System.out.println(this + " положил в корзину "+good);
        Basket.putInBasket(good);
    }

    @Override
    public void goOut() {
        System.out.println(this+" вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }

}
