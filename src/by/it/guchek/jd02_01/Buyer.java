package by.it.guchek.jd02_01;

public class Buyer extends Thread implements Runnable, IBuyer, IUseBacket  {

    private int num;  //номер покупателя

              //конструктор покупателя с его номером
    public Buyer(int num){
        this.num = num;
        this.setName(String.format("Покупатель № %d ", num));
        start();
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
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
    public void takeBacket() {
        System.out.printf("%s Берёт корзину%n", this);
        int pauseForBacket = RandCount.randFrTo(100, 200); //ждет корзину от 0,1 до 0,2 сек
        RandCount.sleep(pauseForBacket);
        System.out.println(this + " подождал "+ pauseForBacket+ " милисекунд");
    }

    @Override
    public void chooseGoods() {

            System.out.printf("%s  Выбирает товар%n", this);
            int pause=RandCount.randFrTo(500, 2000);  //вызываю генератор случайных чисел
            RandCount.sleep(pause);                              //ожидание до 2 сек
            System.out.printf("%s  Закончил выбор товара%n", this);


    }

    @Override
    public void putGoodsToBacket() {

        System.out.printf("%s Положил товар в корзину%n", this);
        int pauseForBacket2 = RandCount.randFrTo(100, 200); //ждет корзину от 0,1 до 0,2 сек
        RandCount.sleep(pauseForBacket2);
        System.out.println(this + " ложил товар в корзину "+ pauseForBacket2+ " милисекунд");

    }

    @Override
    public void goOut() {

        System.out.printf("%s ВЫШЕЛ из магазина%n", this);

    }
}
