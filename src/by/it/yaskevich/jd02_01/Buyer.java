package by.it.yaskevich.jd02_01;

public class Buyer extends Thread /*implements IBuyer*/ {
    void enterToMarket() {
        System.out.println("enter to the market");
    }

    public Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();

    }

    private void goOut() {
        System.out.println("");
    }

    @Override
    public String toString() {
        return getName();
    }

    private void chooseGoods() {
        System.out.println("start");


        System.out.println("stop");
    }
}
