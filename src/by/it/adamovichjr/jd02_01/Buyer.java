package by.it.adamovichjr.jd02_01;

public class Buyer extends Thread implements IBuer, IUseBacket {

    Buyer(int number) {
        super("Buyer № " + number + " ");
        start();

    }
    private boolean pensioner = Time.fromTo(1, 4) == 1;
    private int valueOfchosesGoods = Time.fromTo(1, 4);
    private int speedPensionerOrNormal = pensioner?150:100;

    @Override
    public void enterToMarket() {
        System.out.println(this.getName() + "Enter to the market");
        Market.countBuyerInMarket++;
        takeBacket();
    }

    @Override
    public String choseGoods() {
        int pause = Time.fromTo(500, 1500) *speedPensionerOrNormal/100*Time.BUYERS_SPEED;
        Time.sleep(pause);
        String good = Goods.getGood();
        System.out.println(this.getName() + "chose " + good);
        return good;
    }

    @Override
    public void run() {
        enterToMarket();
        for (int i = 0; i < valueOfchosesGoods; i++) {
            String good = choseGoods();
            putGoodsToBacet(good);
        }
        goToOut();
    }

    @Override
    public void goToOut() {
        Market.countBuyerInMarket--;
        System.out.println(this.getName() + "Go home");
    }

    @Override
    public void takeBacket() {
        int pause = Time.fromTo(100, 200)*speedPensionerOrNormal/100*Time.BUYERS_SPEED;
        Time.sleep(pause);
        System.out.println(this.getName() + "take backet ");
    }

    @Override
    public void putGoodsToBacet(String good) {
        int pause = Time.fromTo(100, 200)*speedPensionerOrNormal/100*Time.BUYERS_SPEED;
        Time.sleep(pause);
        System.out.println(this.getName() + "put " + good +" to backet");
    }
}
