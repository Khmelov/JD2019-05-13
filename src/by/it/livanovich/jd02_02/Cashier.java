package by.it.livanovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Cashier implements Runnable {
    static final Object monitor = new Object();
    private String name;
    private List<Cashier> cashiers=new ArrayList<>();

    Cashier(int number) {
        name = "Кассир №" + number + " ";
    }

    @Override
    public void run() {
        while (!Dispatcher.planIsDone()) {
            if (countWorkCashier(needsOfCashiers())) {
                Buyer buyer = Queue.deductBuyer();
                if (buyer != null) {
                    System.out.println(this + "начал обслуживать " + buyer);
                    int timeout = Rnd.Rnd(2000, 5000);
                    Rnd.sleep(timeout);
                    System.out.println("В корзине " + buyer + ": ");
                    double sum = 0;
                    Good good;
                    while ((good = buyer.getBacket().extractBasket()) != null) {
                        System.out.println(good);
                        sum += good.getPrice();
                    }
                    System.out.printf("Итого: %4.2f\n", sum);
                    System.out.println(this + "закончил обслуживать " + buyer);
                    synchronized (buyer) {
                        buyer.notifyAll();
                    }
                }
            } else synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }

    static int needsOfCashiers (){
        int needs= (int) Math.ceil(Queue.getQueueOfBuyersSize()/5);
        return needs;
    }

    boolean countWorkCashier (int needs){
        if (cashiers.size()<needs){
            cashiers.add(this);
        }
        else if (cashiers.size()<needs){
            cashiers.remove(this);
            return false;
        }
        else {
            if (!cashiers.contains(this));
            return false;
        }
        return true;
    }
}
