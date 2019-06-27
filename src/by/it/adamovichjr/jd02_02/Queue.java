package by.it.adamovichjr.jd02_02;


import java.util.Deque;
import java.util.LinkedList;

class Queue {

    private Queue() {
    }

    static Deque<Buyer> deque = new LinkedList<>();

    synchronized static void add(Buyer buyer) {
            deque.addLast(buyer);
    }

    synchronized static Buyer extract(){
        return deque.pollFirst();
    }


}
