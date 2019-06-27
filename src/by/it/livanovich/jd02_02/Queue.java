package by.it.livanovich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;


public class Queue {
    private static Deque <Buyer> queueOfBuyers=new LinkedList<>();

    synchronized static void addBuyer (Buyer buyer){
        queueOfBuyers.add(buyer);
    }

    synchronized static void deductBuyer (Buyer buyer) {
        queueOfBuyers.pollFirst();
    }
}
