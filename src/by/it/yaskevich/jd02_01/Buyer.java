package by.it.yaskevich.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBasket {

    private boolean pensioner = false;

    Buyer(int number) {
        super("Buyer №" + number);
    }

    @Override
    public String toString() {
        return getName() + (isPensioner() ? " (пенсионер)" : "");
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
        Market.shoppingBuyers.add(this);
        printState(this + " вошел в магазин");
    }

    @Override
    public void chooseGoods() {
        printState(this + " начал выбирать товары");
        int countGoods = Utilities.rnd(1, 4);
        for (int i = 0; i < countGoods; i++) {
            Utilities.sleep(Utilities.rnd(makeDelay(500), makeDelay(2000)));
            printState(this + " выбрал " + Goods.getRandomGood());
            putGoodsToBasket();
        }
        printState(this + " завершил выбирать(" + countGoods + ")");
    }

    @Override
    public void goOut() {
        Market.shoppingBuyers.remove(this);
        printState(this + " вышел из магазина");

    }

    @Override
    public void takeBasket() {
        Utilities.sleep(Utilities.rnd(makeDelay(100), makeDelay(200)));
        printState(this + " взял корзину");
    }

    @Override
    public void putGoodsToBasket() {
        Utilities.sleep(Utilities.rnd(makeDelay(100), makeDelay(200)));
        printState(this + " положил товар в корзину");
    }

    private boolean isPensioner() {
        return pensioner;
    }

    void setPensioner(boolean pensioner) {
        this.pensioner = pensioner;
    }

    private int makeDelay(int value) {
        return (int)(value * (isPensioner() ? 1.5 : 1));
    }

    private void printState(String text) {
        if (Market.printStatesBuyer) {
            System.out.println(text);
        }
    }
}
