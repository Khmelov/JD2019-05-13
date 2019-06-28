package by.it.dnevar.jd02_01;

public class Buyer extends Thread implements IBuyer, Runnable {

    int number;
    Basket basket = new Basket(this.getName());

    Buyer(int number){
        this.number = number;
        this.setName("Покупатель № " + number);
    }

    @Override
    public void run(){
        Basket basket = new Basket(this.getName());
        enterToMarket();
        basket.takeBasket();
        chooseGoods();
        basket.putGoodstobasket();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");

    }

    @Override
    public void chooseGoods() {
        Good goodsInMarket = new Good();
        try {
            int timeout = Rnd.fromTo(500, 2000);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(this + " //некоректное завершение ожидания");;
        }
        int numOfGoods = Rnd.fromTo(0,4);
        for (int i = 0; i < numOfGoods; i++) {
            System.out.println(this + " выбрал " + goodsInMarket.getRandomGood());
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
