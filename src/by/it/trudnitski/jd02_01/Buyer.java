package by.it.trudnitski.jd02_01;

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
        System.out.println(this + " enter to the market ");

    }

    @Override
    public void chooseGoods() {
        int timeOut = Helper.randomeGet(500, 2000);
        Helper.sleep(timeOut);
        int randome = Helper.randomeGet(1, 5);
        for (int i = 0; i < randome; i++) {
            System.out.println(this + " choose " + Goods.getRandomGood());
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + "  out from the market");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.randomeGet(100, 200));
        System.out.println(this + " took the basket");

    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.randomeGet(100, 200));
        System.out.println(this + "  put goods to the basket");

    }
}
