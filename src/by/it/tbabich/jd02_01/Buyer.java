package by.it.tbabich.jd02_01;

public class Buyer extends Thread implements IBuyer {
    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    public Buyer(int number) {
        super("Buyer" + number);
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start choose");
        int timeout = Util.rnd(500, 2000);
        String good = Goods.getRandomGood();
        System.out.println(this + " choosed");
        System.out.println(this + " end choose");


    }

    @Override
    public void goOut() {
        System.out.println(this + " out");
    }

    @Override
    public String toString() {
        return getName();
    }
}
