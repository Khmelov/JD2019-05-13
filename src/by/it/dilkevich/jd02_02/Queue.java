package by.it.dilkevich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queue {

    private Queue() {
    }

    private static Deque<Buyer> byersQueue = new LinkedList<>();

    synchronized static void add(Buyer buyer) {
        byersQueue.addLast(buyer);
    }

    synchronized static Buyer getBuyer(){
        return byersQueue.pollFirst();
    }


}
