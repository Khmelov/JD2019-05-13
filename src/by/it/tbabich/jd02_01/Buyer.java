package by.it.tbabich.jd02_01;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private Backet backet;
    private boolean pensioneer;
    private double coefSpeed;

    public boolean isPensioneer() {
        return pensioneer;
    }

    public void setPensioneer(boolean pensioneer) {
        this.pensioneer = pensioneer;
        coefSpeed = Util.rnd(1, 2);
    }

    public Buyer(int number) {
        super("Buyer №" + number);
        coefSpeed = 1;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
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
        int quantityGood = Util.rnd(1, 4);
        for (int i = 0; i < quantityGood; i++) {
            int timeout = Util.rnd(500, 2000);
            Util.sleep((int) (timeout * coefSpeed));
            int idGood = Goods.getRandomGood();
            String good = Goods.getNameGood(idGood);
            int cost = Goods.getCostGood(idGood);
            System.out.println(this + " choose " + good);
            putGoodsToBacket(idGood, cost);
        }
        System.out.println(this + " stop choose goods");
    }

    @Override
    public void goOut() {
        System.out.println(this + " out from the market");
        Market.deleteBuyer(this);
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        System.out.println(this + " taked backet");
        backet = new Backet();
        int timeout = Util.rnd(100, 200);
        Util.sleep((int) (timeout * coefSpeed));
    }

    @Override
    public void putGoodsToBacket(int good, int cost) {
        System.out.printf("%s push %s to backed\n", this, Goods.getNameGood(good));
        backet.putToBacket(good, cost);
        int timeout = Util.rnd(100, 200);
        Util.sleep((int) (timeout * coefSpeed));
    }
}
