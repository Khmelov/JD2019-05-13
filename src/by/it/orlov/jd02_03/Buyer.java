package by.it.orlov.jd02_03;

import java.util.Map;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

import static by.it.orlov.jd02_03.Goods.getRandomGood;

public class Buyer extends Thread implements IBuyer {

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
    }

    private boolean flagWait = false;
    public static AtomicInteger hall = new AtomicInteger(0);

    private static Semaphore sema = new Semaphore(20);


    static void addInHall() {
        hall.getAndIncrement();
    }

    static void removeFromHall() {
        hall.getAndDecrement();
    }

    public void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    @Override
    public void run() {
        enterToMarket();
        chooseGoods();
        goToQueue();
        goOut();
    }

    @Override
    public void enterToMarket() {
        addInHall();
        System.out.println(this + " enter to the market"+hall);
    }

    @Override
    public void chooseGoods() {
        System.out.println(this + " start choose goods");
        for (int i = 0; i < 1 + (int) (Math.random() * 4); i++) {
            Good g = getRandomGood();
            Basket.add(g);
            System.out.println(this + "выбрал" + g);
            Util.sleep(Util.rnd(500, 2000));
        }

    }

    @Override
    public void goToQueue() {
        Queue.add(this);
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
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
    public void goOut() {
        removeFromHall();
        System.out.println(this + " out from the market"+ hall);
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
