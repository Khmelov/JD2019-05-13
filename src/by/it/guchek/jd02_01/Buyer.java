package by.it.guchek.jd02_01;

public class Buyer extends Thread implements Runnable, IBuyer  {

    int num;  //номер покупателя

              //конструктор покупателя с его номером
    public Buyer(int num){
        this.num = num;
        this.setName(String.format("Покупатель № %d ", num));
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {

        System.out.printf("%s вошёл в магазин%n", this);

    }

    @Override
    public void chooseGoods() {

    }

    @Override
    public void goOut() {

        System.out.printf("%s вышел из магазина%n", this);

    }
}
