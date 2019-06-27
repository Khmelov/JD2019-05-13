package by.it.akhmelev.jd02_01;

public class Buyer extends Thread implements IBuyer {

    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
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
        int timeout = Util.rnd(500, 2000);
        Util.sleep(timeout);
        String good = Goods.getRandomGood();
        System.out.println(this + " choose " + good);
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
}
