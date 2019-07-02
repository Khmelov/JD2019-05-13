package by.it.dilkevich.jd02_02;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class Buyer extends Thread implements IBuyer, IUseBacket {


    private boolean pensioneer;
    double slowSpeed;
    Backet backet;
    double goodsCost = 0;
    static Map<String, Map<String,Double>> buyersGoods = new HashMap<>();
    static int sumForDay = 0;

    void speed(){

        if (pensioneer){
            slowSpeed = 1.5;
        }
        else slowSpeed = 1;
    }

    public Buyer(String name, Boolean isPensioneer) {
        super("Покупатель № "+name);
        Plan.setCountOfBuyers();
        this.pensioneer = isPensioneer;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    public Map<String, Double> getGoodsFromBacket(){

        return  backet.getGoodsInBacket();
    }
    @Override
    public void enterToMarket() {

        speed();
        if(pensioneer)
        System.out.println(this + " вошел в магазин - пенсирнер");
        else
            System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBacket() {

        Util.sleep(Util.rnd(100, 200), slowSpeed);
        backet = new Backet();
        System.out.println(this + " взял корзину");
    }

    String good = "";

    @Override
    public void putGoodsToBacket() {

        Util.sleep(Util.rnd(100, 200), slowSpeed);
        backet.addGoodToBacket(good, Goods.getCostOfGood(good));
        System.out.println(this + " положил " + good + " в корзину");
    }

    @Override
    public void chooseGoods() {

        int countOfGoods = Util.rnd(1,4);
        System.out.println(this + " начал выбирать товары");

        for (int i = 0; i < countOfGoods; i++) {

            Util.sleep(Util.rnd(500,2000), slowSpeed);
            good = Goods.getRandomGood();
            System.out.println(this + " выбрал " + good);
            putGoodsToBacket();
        }

        System.out.println(this + " закончил выбирать товары");
    }

    @Override
    public void goToQueue() {
        System.out.println(this + " пошел на кассу");


        Queue.add(this);
        Plan.setKlientInQueue();

        synchronized (MainCashier.monitor) {
            MainCashier.monitor.notify();
        }
        synchronized (this) {
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void payForGoods() {
        System.out.println(this + " заплатил за продукты");
    }

    @Override
    public void goOut() {
        System.out.println(this + " покинул магазин");
        synchronized (MainCashier.monitor) {
            MainCashier.monitor.notify();
        }
    }

    @Override
    public String toString() {
        return getName();
    }

}
