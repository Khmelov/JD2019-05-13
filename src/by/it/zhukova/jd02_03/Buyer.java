package by.it.zhukova.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class Buyer extends Thread implements IBuyer, IUseBacket {

     Buyer(int number, boolean pensioneer) {
           super("Buyer №" + number);
        this.pensioneer = pensioneer;
         Dispatcher.addBuyer();
     }
    private Good good;
    private boolean pensioneer;
    private List<Good> list = new ArrayList<>();
    static int ColCasier=0;
    private boolean flagWait = false;
    private static Semaphore semaphore=new Semaphore(20);

    public List<Good> getList() {
        return list;
    }

    public void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    @Override
    public void run() {
        enterToMarket();
        takeBacket();
        try {
            semaphore.acquire(); //взяли разрешение у семафора
            System.out.println(this + " start choose goods");
            int count = Util.rnd(1,4);
            for (int i = 0; i < count; i++) {
                chooseGoods();
                putGoodsToBacket();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        finally {
            System.out.println(this + " stop choose goods");
            semaphore.release(); //вернули разрешение
        }

        try {
            goToQueue();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        goOut();
    }

    @Override
    public void enterToMarket() {
        if (pensioneer) {
            System.out.println(this + " enter to the market(pensioneer)");
        }
        else
            System.out.println(this + " enter to the market");
    }

    @Override
    public void takeBacket() {
        int timeout = Util.rnd(100, 200);
        if (pensioneer) {
            Util.sleep((int)(timeout*1.5));
        }
        else {
            Util.sleep(timeout);
        }
        System.out.println( this + " take a basket" );
    }

    @Override
    public void chooseGoods() {
        int timeout = Util.rnd(500, 2000);
        if (pensioneer) {
            Util.sleep((int)(timeout*1.5));
        }
        else {
            Util.sleep(timeout);
        }
        good = Goods.getRandomGood();
        System.out.println( this + " choose "+ good );
    }

    @Override
    public void putGoodsToBacket() {
        int timeout = Util.rnd(100, 200);
        if (pensioneer) {
            Util.sleep((int)(timeout*1.5));
        }
        else {
            Util.sleep(timeout);
        }
        Backet.putBacket(list,good);
        System.out.println( this + " put " +good.getName()+" to the basket" );
    }

    @Override
    public void goToQueue() throws InterruptedException {
        Queue.add(this,pensioneer);
        System.out.println(this+" go to Queue");
        if ((Queue.size() <5 )&&(ColCasier==0)){
            synchronized (Cashier.monitor) {
                    Cashier.monitor.notify();
                }
            ColCasier++;
        }
              if ((Queue.size() >5 )&&(ColCasier==1)) {
            synchronized (Cashier.monitor) {
                Cashier.monitor.notify();
            }
            ColCasier++;
        }
                if ((Queue.size() >10 )&&(ColCasier==2)) {
            synchronized (Cashier.monitor) {
                Cashier.monitor.notify();
            }
            ColCasier++;
        }
                if ((Queue.size() >15)&&(ColCasier==3)) {
            synchronized (Cashier.monitor) {
                Cashier.monitor.notify();
            }
            ColCasier++;
        }
                  if ((Queue.size() >20 )&&(ColCasier==4)) {
            synchronized (Cashier.monitor) {
                Cashier.monitor.notify();
            }
            ColCasier=1;
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
    public void goOut() {
        System.out.println( this + " go out from the market" );
        Dispatcher.completeBuyer();
        if (Dispatcher.planComplete()){
            System.out.println("plan completed");
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
        }
    }

    @Override
    public String toString() {
        return getName();
    }
}
