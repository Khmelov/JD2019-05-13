package by.it.maniuk.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Cashier implements Runnable {

    final static Object monitor = new Object();

    int number;
    private String name;

    Cashier(int number) {
        name = "Cashier №" + number + " ";
        this.number = number;
    }

    @Override
    public void run() {
        while (! Dispatcher.planComplete()) {
            Buyer buyer = null;
                if (Queue.needCashier()) {
                 // Queue.dellCashiers(this);
                  Queue.extractCashier();
                   buyer = Queue.extractBuyer();
                }

            if (buyer != null) {
                System.out.println(this + "started service of " + buyer);
                int timeout = Util.rnd(2000, 5000);
                Util.sleep(timeout);

               print(buyer);

                System.out.println(this + "stopped service of " + buyer);
                synchronized (buyer){
                    buyer.notify();
                }

            } else {
                synchronized (monitor){
                    try {
                        Queue.addCashier(this);
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void print(Buyer buyer) {
        int columnQuality = 6;
        int columnLeight = 10;
        StringBuilder probel = new StringBuilder();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < columnQuality; i++) {
            sb.append("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯");
            if (i < columnQuality - 1) sb.append("|");
        }
        sb.append("|");
        sb.append("\n");
        if (number != 0) {
            for (int i = 0; i < columnQuality; i++) {
                sb.append("         ");
                if (i == number) {
                    sb.append("Cashier N" + number);
                    break;
                }

            }
        } else {
            sb.append("Cashier N" + number);}

            System.out.println(sb.toString());


//
//         List<String> list =  buyer.getGoods();
//        StringBuilder sb = new StringBuilder();
//        StringBuilder probel = null;
//        for (int i = 0; i < number*15 ; i++) {
//          probel = sb.append(" ");
//        }
//        String t1 = ("Cashier N"+ number), t2 = "| " + buyer.getName(), t3 ="Market cash";
//        sb.append(probel).append(t1).append(t2).append(t3);
//        System.out.println();
//        for (int i = 0; i < list.size(); i++) {
//            String good = list.get(i);
//            sb.append(probel).append(good).append(" ").append(Goods.getCost().get(good)).append("\n");
//        }
//
//        Double cost = 0d;
//        for (String good :list) {
//            cost += Goods.getCost().get(good);
//        }
//        cost = Math.floor(cost * 100) / 100;
//        sb.append("summa = ").append(cost);
//        System.out.println(sb.toString());

    }
    @Override
    public String toString() {
        return name;
    }
}
