package by.it.izaykoff.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        takeBasket();
        chooseGoods();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start choose goods");
        int timeout = Util.rnd(1000, 2000);
        Util.sleep(timeout);
        putGoodsToBasket();
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
    public void takeBasket() {
        System.out.println(this + " took the basket");
    }

    @Override
    public void putGoodsToBasket() {
        int count;
        for (count = 1; count < 5; count++) {
            String good = Goods.getRandomGood();
            System.out.println(this + " choose " + count + " " + good + " put in the basket");
        }
    }
}
