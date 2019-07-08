package by.it.yakimovich.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IBacket {
    private boolean pensioneer;

    Buyer(int number) {
        super("Buyer №" + number);
        Dispatcher.addBuyer();
        int a = (number % 4);
        pensioneer = a == 0;
    }

    public List<String> list = new ArrayList<>();
    private List<Integer> listPrice=new ArrayList<>();

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
    public void enterToMarket() {
        System.out.println(this + " enter to the market");
    }

    @Override
    @SuppressWarnings("Duplicates") //method chooseGoods() need in jd02_01 too
    public void chooseGoods() {
        try {
            Dispatcher.buyerChoosingGoodsSemaphore.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (pensioneer) {
            System.out.println(this + " is pensioneer");
        }
        System.out.println(this + " start choose goods");
        int amount= Util.rnd(1,4);
        for (int i = 0; i < amount; i++) {
            int timeout = Util.rnd(500, 2000);
            if (!pensioneer) {
                Util.sleep(timeout);
                String good = Goods.getRandomGood();
                System.out.println(this + " choose " + good);
                int cost= Goods.getPrice(good);
                list.add(good);
                listPrice.add(cost);

            } else {
                Util.sleep((int) (timeout * 1.5));
                String good = Goods.getRandomGood();
                System.out.println(this + " choose " + good);
                int cost = Goods.getPrice(good);
                list.add(good);
                listPrice.add(cost);

                System.out.println(this + " stop choose goods");
            }}
        Dispatcher.buyerChoosingGoodsSemaphore.release();}


    @Override
    public void goToQueue() {
        Queue.add(this);
        synchronized (Cashier.monitor) {
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
    public void goOut() {
        System.out.println(this + " out from the market");
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor){
            Cashier.monitor.notifyAll();
        }
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public void takeBacket() {
        if (!pensioneer) {
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout);
            System.out.println(this + " took backet");
        } else {
            int timeout = Util.rnd(150, 300);
            Util.sleep(timeout);
            System.out.println(this + " took backet");
        }

    }



    @Override
    public void putGoodsToBacket() {
        int res=0;
        if (!pensioneer) {
            int timeout = Util.rnd(100, 200);
            Util.sleep(timeout);
            String result = list.toString().replace("[", "").replace("]", "");

            for (int j = 0; j <listPrice.size() ; j++) {
                res = res + listPrice.get(j);

            }System.out.println(this + " put in backet " + result+". Sum in check: " + res + " BYN");
        } else {
            int timeout = Util.rnd(150, 300);
            Util.sleep(timeout);
            String result = list.toString().replace("[", "").replace("]", "");
            for (int j = 0; j <listPrice.size() ; j++) {
                res = res + listPrice.get(j);



        }System.out.println(this + " put in backet " + result+". Sum in check: " + res + " BYN");

    }}}
