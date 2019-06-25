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

        System.out.printf("%s ВОШЁЛ в магазин%n", this);

    }

    @Override
    public void chooseGoods() {

            System.out.printf("%s  Выбирает товар%n", this);
            int pause=RandCount.randFrTo(500, 2000);  //вызываю генератор случайных чисел
            RandCount.sleep(pause);                              //ожидание до 2 сек
            System.out.printf("%s  Закончил выбор товара%n", this);


    }

    @Override
    public void goOut() {

        System.out.printf("%s ВЫШЕЛ из магазина%n", this);

    }
}
