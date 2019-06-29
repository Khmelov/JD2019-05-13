package by.it.dnevar.jd02_01;

public class Buyer extends Thread implements IBuyer, Runnable {

    int number;
    Basket basket = new Basket();
    Good goodsInMarket = new Good();
    static int time;

    private boolean pensioneer = Utility.fromTo(1,4)==4;

    Buyer(int number){
        if(pensioneer){
            setName("Покупатель(пенсионер) № " + number);
            time = Dispetcher.TIMEPENSIONEER;
        }else{
            setName("Покупатель № " + number);
            time = Dispetcher.TIMEBUYER;
        }
    }

    @Override
    public void run(){
        enterToMarket();
        basket.takeBasket();
        System.out.println(getName()+ " взял корзину");
        chooseGoods();
        basket.putGoodsToBasket();
        System.out.println(getName()+" положил товары в корзину");
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");

    }

    @Override
    public void chooseGoods() {
        try {
            int timeout = Utility.fromTo(5*time, 20*time);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(this + " //некоректное завершение ожидания");;
        }
        int numOfGoods = Utility.fromTo(0,4);
        for (int i = 0; i < numOfGoods; i++) {
            String chosedGoodKey = Good.getRandomGood();
            Double goodPrice = Good.getRandomGoodKey(chosedGoodKey);
            System.out.println(this + " выбрал " + chosedGoodKey);
            Basket.goodsInBasket.put(chosedGoodKey, goodPrice);
        }
    }

    @Override
    synchronized public void goOut() {
        System.out.println(this + " вышел из магазина");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
