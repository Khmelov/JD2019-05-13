package by.it.lasotskaya.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    public Buyer(int number) {
        super("Buyer №" + number);
    }

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
        Util.sleep(Util.rnd(500,2000));
        System.out.println(this + "choose goods");
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
        int timeout = Util.rnd(100, 200);
        Util.sleep(timeout);
        System.out.println(this + " choose basket");
    }

    @Override
    public void putGoodsToBacket() {
        int r = Util.rnd(1,4);
        for ( int i = 1; i <=r ; i++ ) {
            Util.sleep(Util.rnd(100, 200));
            int w = Util.rnd(0, Goods.pairs.size()-1);
            String key = Goods.pairs.get(w).getKey();
            Double value = Goods.pairs.get(w).getValue();

            System.out.println(this+"Put goods " + key +" " + value + " to basket");
        }
    }
}
