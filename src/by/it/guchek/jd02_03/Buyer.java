package by.it.guchek.jd02_03;

import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements Runnable, IBuyer, IUseBacket {

    private int num;  //номер покупателя
    private volatile boolean pensioneer=false;
    Bucket1 bucket;

    private static Semaphore semForBuyers = new Semaphore(20);

    //конструктор покупателя с его номером
    public Buyer(int num){

        this.num = num;
        Dispatcher.addBuyer();

        if (num%4==0) pensioneer=true;
        else pensioneer=false;

        if (!pensioneer)
            this.setName(String.format("Покупатель № %d ", num));
        else{
            this.setName(String.format("Покупатель № %d - пенсионер", num));
        }

    }

    private boolean flagWait = false;

    public void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        chooseGoods();
        putGoodsToBacket();
        goToQueue();
        goOut();
    }

    @Override
    public String toString() {
        return this.getName();
    }

    @Override
    public void enterToMarket() {

        this.bucket = new Bucket1();
        System.out.printf("%s ВОШЁЛ в магазин%n", this);

    }

    @Override
    public void takeBacket() {
        System.out.printf("%s Берёт корзину%n", this);
        if (!pensioneer){
            int pauseForBacket = RandCount.randFrTo(100, 200);//ждет корзину от 0,1 до 0,2 сек
            RandCount.sleep(pauseForBacket);}
        else {
            int pauseForBacket = (int) (RandCount.randFrTo(100, 200)*1.5);//ждет корзину от 0,15 до 0,3 сек
            RandCount.sleep(pauseForBacket);
            //System.out.println(this + " подождал "+ pauseForBacket1+ " милисекунд");
        }

    }

    @Override
    public void chooseGoods() {

        try {
        semForBuyers.acquire();
        System.out.printf("%s Выбирает товар%n", this);
        if (!pensioneer){
            int pause = RandCount.randFrTo(500, 2000);   //вызываю генератор случайных чисел
            RandCount.sleep(pause); }                             //ожидание до 2 сек
        else {
            int pause = (int)(RandCount.randFrTo(500, 2000)*1.5);
            RandCount.sleep(pause);}

        for (int i = 0; i < RandCount.randFrTo(1, 4); i++) {
            Good good = Goods.getRandGood();
            bucket.add(good);
            System.out.println(this + " выбрал " + good);
        }
        System.out.printf("%s Закончил выбор товара%n", this);
        }
        catch (Exception e) {
            e.printStackTrace();
        } finally {
        semForBuyers.release();
        }


    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        synchronized (Cashier.monitor){
            Cashier.monitor.notifyAll();
        }
        
        flagWait = true;
        synchronized (this) {
            while (flagWait) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void putGoodsToBacket() {

        System.out.printf("%s Положил в корзину товар %n", this);

        //bucket.readGood(this.getName());
        if (!pensioneer){
            int pauseForBacket = RandCount.randFrTo(100, 200); //кладет в корзину от 0,1 до 0,2 сек
            RandCount.sleep(pauseForBacket);
        }
        else {
            int pauseForBacket = (int)(RandCount.randFrTo(100, 200)*1.5);
            RandCount.sleep(pauseForBacket);
            //System.out.println(this + " ложил товар в корзину "+ pauseForBacket21+ " милисекунд");
        }
    }

    @Override
    public void goOut() {

        System.out.printf("%s ВЫШЕЛ из магазина%n", this);
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor){
            Cashier.monitor.notifyAll();
        }

    }

}
