package by.it.dilkevich.jd02_03;

import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Semaphore;

public class Buyer implements IBuyer, Runnable {

    private String name;

    public String getName() {
        return name;
    }

    Buyer(int number) {
        name = "Buyer №" + number;
        Dispatcher.addBuyer();
    }

    static Semaphore semaphore = new Semaphore(20);
    private boolean flagWait = false;
    Backet backet = new Backet();

    public void setFlagWait(boolean flagWait) {
        this.flagWait = flagWait;
    }

    @Override
    public void run() {

        try {
            semaphore.acquire();
            enterToMarket();
            chooseGoods();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            semaphore.release();
        }
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

        System.out.println(name + " start choose goods");
        Dispatcher.addPeoplesChosenGoods();
        System.out.println(Dispatcher.getPeoplesChosenGoods());
        int countOfGoods = Util.rnd(1, 4);

        for (int i = 0; i < countOfGoods; i++) {
            int timeout = Util.rnd(500, 2000);
            Util.sleep(timeout);
            Good good = Goods.getRandomGood();
            backet.addGoodToBacket(good.getName(), good.getPrice());
            System.out.println(name + " choose " + good);
        }
        System.out.println(name + " stop choose goods");
        Dispatcher.delPeoplesChosenGoods();
    }

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

    public void payForGoods() {

        StringBuilder sb = new StringBuilder();
        Map<String, Double> goodsFromBacket = backet.getGoodsInBacket();
        Iterator<Map.Entry<String, Double>> iterator = goodsFromBacket.entrySet().iterator();

        sb.append("----------------------------------------------------------------------\n");
        sb.append(name + " payed for: ").append("\n");
        while (iterator.hasNext()) {
            Map.Entry<String, Double> next = iterator.next();
            sb.append(next.getKey()).append(": ").append(next.getValue()).append("\n");
        }
        sb.append("Total: " + backet.sumGoodsCost);
        sb.append("\n--------------------------------------------------------------------\n");
        System.out.println(sb);

    }

    @Override
    public void goOut() {
        System.out.println(name + " out from the market");
        Dispatcher.completeBuyer();
        synchronized (Cashier.monitor) {
            Cashier.monitor.notifyAll();
        }
    }

}
