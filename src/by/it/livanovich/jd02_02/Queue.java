package by.it.livanovich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;


public class Queue {

    private Queue() {

    }

    public static int getQueueOfBuyersSize() {
        return queueOfBuyers.size();
    }

    private static Deque<Buyer> queueOfBuyers = new LinkedList<>();

    synchronized static void addBuyer(Buyer buyer) {
        queueOfBuyers.add(buyer);
        System.out.println(buyer+" встал в очередь");
    }

    synchronized static Buyer deductBuyer() {
        return queueOfBuyers.pollFirst();
    }
}
