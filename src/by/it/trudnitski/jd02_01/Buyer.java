package by.it.trudnitski.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer,IUseBacket {


    public Buyer(int number){
        super("Buyer №"+number);
    }
private List<String> goods=new ArrayList<>();

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        shop();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this+"enter to the market");

    }

    @Override
    public void chooseGoods() {
        System.out.println(this+"  start choose the goods");
        int timeOut = Helper.randomeGet(500, 2000);
        Helper.sleep(timeOut);
        String good = Goods.getRandomGood();
        System.out.println(this+"choose the good  "+good);
        System.out.println(this+"  stop choose the goods");
        goods.add(good);

    }

    private void shop(){
        for (int i = 0; i <Goods.getRandomSomeGoods() ; i++) {
           chooseGoods();
           putGoodsToBacket();
        }
        StringBuilder sb=new StringBuilder();
        for (String good : goods) {
            sb.append(good).append(" ").append(Goods.getCost().get(good)).append(" : ");

        }
        System.out.println(this +" stop choose the goods"+sb.toString());
    }

    @Override
    public void goOut() {
        System.out.println(this+"  out from the market");

    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void takeBacket() {
        Helper.sleep(Helper.randomeGet(100,200));
        System.out.println(this + " took the basket");

    }

    @Override
    public void putGoodsToBacket() {
        Helper.sleep(Helper.randomeGet(100,200));
        System.out.println(this+"  put  "+Goods.getRandomGood()+"  to the basket");

    }
}
