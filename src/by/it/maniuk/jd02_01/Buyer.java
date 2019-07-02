package by.it.maniuk.jd02_01;

import java.util.ArrayList;

import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket {
    private boolean pensioneer;

    private List<String> goods =new ArrayList<>();

    Buyer(int number) {
        super("Buyer №" + number);
    }

     private void isPensionerHere() {
         pensioneer= Util.rnd(4) == 1;
     }

    @Override
    public void run() {
        isPensionerHere();
        enterToMarket();
        takeBacket();
        shopping();
        goOut();
    }

    private void shopping() {
        for (int i = 0; i < Goods.getRandomQuantityOfGoods() ; i++) {
            chooseGoods();
            putGoodsToBacket();
        }
        StringBuilder sb = new StringBuilder();
        for (String good : goods) {
            sb.append(good).append(" ").append(Goods.getCost().get(good)).append("  ");
        }
        Double cost=0d;
        for (String good : goods) {
           cost += Goods.getCost().get(good);
        }
        cost = Math.floor(cost*100)/100;
        sb.append("summa = ").append(cost);
        if (pensioneer) sb.append(" pensionner ");
        System.out.println(this + " stop choose goods: "+ sb.toString());
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start choose goods");
        int timeout = Util.rnd(500, 2000, pensioneer);
        Util.sleep(timeout);
        String good = Goods.getRandomGood();
        System.out.println(this + " choose " + good);
        goods.add(good);
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
        int timeout = Util.rnd(100, 200,pensioneer);
        Util.sleep(timeout);
        System.out.println(this + " took the basket");
    }

    @Override
    public void putGoodsToBacket() {
            int timeout = Util.rnd(100, 200,pensioneer);
            Util.sleep(timeout);
            System.out.println(this + " put goods to the basket");


    }

}
