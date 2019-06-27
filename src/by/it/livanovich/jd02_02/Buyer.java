package by.it.livanovich.jd02_02;

import static by.it.livanovich.jd02_01.Basket.Basket;


public class Buyer extends Thread implements IBuyer, IUseBacket {

    private String good;
    private boolean pensionner = false;
    static int count = 0;

    public Buyer(int number) {
        super("Покупатель № " + number);
        counter();
    }

    public static void counter() {
        count++;
    }

    public void run() {
        if (count % 4 == 0) {
            pensionner = true;
        }
        enterToMarket();
        takeBacket();
        int countGoods = Rnd.Rnd(1, 4);
        for (int i = 1; i <= countGoods; i++) {
            chooseGoods();
            putGoodsToBacket();
            Basket.putInBasket(good);
        }
        Basket(getName());
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBacket() {
        int timeout = Rnd.Rnd(100, 200);
        if (pensionner) {
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        } else {
            Rnd.sleep(timeout / Dispatcher.K_SPEED);
        }
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout = Rnd.Rnd(500, 2000);
        if (pensionner) {
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        } else {
            Rnd.sleep(timeout / Dispatcher.K_SPEED);
        }
        good = Goods.getRandomGood();
        System.out.println(this + " выбрал товар " + good);
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Rnd.Rnd(100, 200);
        if (pensionner)
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        else Rnd.sleep(timeout / Dispatcher.K_SPEED);
        System.out.println(this + " положил в корзину " + good);
        Basket.putInBasket(good);
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return getName();
    }

}
