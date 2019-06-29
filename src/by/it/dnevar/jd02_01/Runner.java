package by.it.dnevar.jd02_01;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Runner {

    private static int countBuyers = 0;


    private static List<Buyer> buyersList = new LinkedList<>();

    public static void main(String[] args) throws InterruptedException {

        System.out.println("Магазин открыт");
        int countBuyersIn = 0;
        int limitBuyersIn;

        for(int time = 0; time<120;time++){
            if (time % 60 <= 30) {
                limitBuyersIn = (time % 60) + 10;
            } else {
                limitBuyersIn = 40 + (30 - (time % 60));
            }
            Thread.sleep(10);
            int count = Utility.fromTo(0,2)+ (limitBuyersIn - countBuyersIn);
            while (count>0) {
                countBuyers++;
                Buyer buyer = new Buyer(countBuyers);
                buyer.start();
                buyersList.add(buyer);
                countBuyersIn++;
                count--;
            }
        }

        Iterator<Buyer> iterator = buyersList.iterator();
        while (iterator.hasNext()){
            Buyer buyerThread = iterator.next();
                buyerThread.join();
        }

        System.out.println("Магазин закрыт");
    }
}
