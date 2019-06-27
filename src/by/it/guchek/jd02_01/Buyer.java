package by.it.guchek.jd02_01;

public class Buyer extends Thread implements Runnable, IBuyer, IUseBacket {

    private int num;  //номер покупателя
    private static volatile boolean pensioneer=false;

              //конструктор покупателя с его номером
    public Buyer(int num){
        this.num = num;
        if (num%4==0) pensioneer=true;
        else pensioneer=false;

        if (!pensioneer)
            this.setName(String.format("Покупатель № %d ", num));
        else{
            this.setName(String.format("Покупатель № %d - пенсионер", num));}
        //start();
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
        if (!pensioneer){
            int pauseForBacket0 = RandCount.randFrTo(100, 200);//ждет корзину от 0,1 до 0,2 сек
            RandCount.sleep(pauseForBacket0);}
        else {
            int pauseForBacket1 = (int) (RandCount.randFrTo(100, 200)*1.5);//ждет корзину от 0,15 до 0,3 сек
            RandCount.sleep(pauseForBacket1);
            //System.out.println(this + " подождал "+ pauseForBacket1+ " милисекунд");
        }

    }

    @Override
    public void chooseGoods() {

            System.out.printf("%s Выбирает товар%n", this);
        if (!pensioneer){
            int pause0 =RandCount.randFrTo(500, 2000);   //вызываю генератор случайных чисел
            RandCount.sleep(pause0); }                             //ожидание до 2 сек
        else {
            int pause1 = (int)(RandCount.randFrTo(500, 2000)*1.5);
            RandCount.sleep(pause1);}
            System.out.printf("%s Закончил выбор товара%n", this);


    }

    @Override
    public void putGoodsToBacket() {

        System.out.printf("%s Положил в корзину товар: %n", this);
        Bucket.goodsInBacket();
        if (!pensioneer){
            int pauseForBacket20 = RandCount.randFrTo(100, 200); //кладет в корзину от 0,1 до 0,2 сек
            RandCount.sleep(pauseForBacket20);
        }
        else {
            int pauseForBacket21 = (int)(RandCount.randFrTo(100, 200)*1.5);
            RandCount.sleep(pauseForBacket21);
            //System.out.println(this + " ложил товар в корзину "+ pauseForBacket21+ " милисекунд");
        }
    }

    @Override
    public void goOut() {

        System.out.printf("%s ВЫШЕЛ из магазина%n", this);

    }

}
