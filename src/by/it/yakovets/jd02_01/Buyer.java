package by.it.yakovets.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private boolean pensioneer;


    Buyer(int number) {
        super("Buyer №" + number);
    }

    Buyer(int number, boolean pensioneer) {
        super("Buyer №" + number + "(P)");
        this.pensioneer = pensioneer;
    }

    void setPensioneer(boolean pensioneer) {
        this.pensioneer = pensioneer;
    }


    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        int countGoods = Helper.rnd(1, 4);
        for (int i = 0; i < countGoods; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        goOut();

    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter the market");
        Market.buyerIn++;
    }

    @Override
    public void chooseGoods() {
        if (!pensioneer) {
            Helper.sleep(Helper.rnd(500, 2000));
        } else {
            int sleeping = (int) (Helper.rnd(500, 2000) * Dispatcher.P_SPEED);
            Helper.sleep(sleeping);
        }
        String good = Goods.getRandom();
        System.out.println(this + " choose " + good);

    }

    @Override
    public void goOut() {
        System.out.println(this + " out from the market");
        Market.buyerIn--;
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        if (!pensioneer) {
            Helper.sleep(Helper.rnd(100, 200));
        } else {
            Helper.sleep((int) (Helper.rnd(100, 200) * Dispatcher.P_SPEED));
        }
        System.out.println(this + " take backet");
    }

    @Override
    public void putGoodsToBacket() {
        if (!pensioneer) {
            Helper.sleep(Helper.rnd(100, 200));
        } else {
            Helper.sleep((int) (Helper.rnd(100, 200) * Dispatcher.P_SPEED));
        }
        System.out.println(this + " put the good in the backet");

    }
}