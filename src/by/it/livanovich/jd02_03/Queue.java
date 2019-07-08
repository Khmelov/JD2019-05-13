package by.it.livanovich.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;


public class Queue {

    private Queue() {

    }

    public static int getQueueOfBuyersSize() {
        return queueOfBuyers.size();
    }

    private static BlockingDeque<Buyer> queueOfBuyers = new LinkedBlockingDeque<>(30);

    static void addBuyer(Buyer buyer) {
        try {
            queueOfBuyers.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(buyer+" встал в очередь");
    }

    static Buyer deductBuyer() {
        return queueOfBuyers.pollFirst();
    }
}
