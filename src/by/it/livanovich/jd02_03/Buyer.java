package by.it.livanovich.jd02_03;


import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBacket {

    private Good good;
    private boolean pensionner = false;
    static int count = 0;
    private List<Good> list = new ArrayList<>();
    private boolean wait = false;

    public void setWait(boolean wait) {
        this.wait = wait;
    }

    public List<Good> getList() {
        return list;
    }

    public Buyer(int number) {
        super("Покупатель № " + number);
        Dispatcher.addBuyer();
        counter();
    }

    public static void counter() {
        count++;
    }

    public void run() {
        if (count % 4 == 0) {
            pensionner = true;
        }
        enterToMarket();
        takeBacket();
        Integer countGoods = Rnd.Rnd(1, 4);
        synchronized (countGoods) {
            for (int i = 1; i <= countGoods; i++) {
                chooseGoods();
                putGoodsToBacket();
            }
        }
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        System.out.println(this + " вошел в магазин");
    }

    @Override
    public void takeBacket() {
        int timeout = Rnd.Rnd(100, 200);
        if (pensionner) {
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        } else {
            Rnd.sleep(timeout / Dispatcher.K_SPEED);
        }
        System.out.println(this + " взял корзину");
    }

    @Override
    public void chooseGoods() {
        int timeout = Rnd.Rnd(500, 2000);
        if (pensionner) {
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        } else {
            Rnd.sleep(timeout / Dispatcher.K_SPEED);
        }
        good = Goods.getRandomGood();
        System.out.println(this + " выбрал товар " + good);
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Rnd.Rnd(100, 200);
        if (pensionner)
            Rnd.sleep((int) (timeout / Dispatcher.K_SPEED * 1.5));
        else Rnd.sleep(timeout / Dispatcher.K_SPEED);
        System.out.println(this + " положил в корзину " + good);
        Backet.putBacket(list, good);
    }

    @Override
    public void goToQueue() {
        Queue.addBuyer(this);
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
        wait = true;
        synchronized (this) {
            while (wait) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public void goOut() {
        System.out.println(this + " вышел из магазина");
        Dispatcher.deductBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
