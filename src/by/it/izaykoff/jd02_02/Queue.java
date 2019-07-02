package by.it.izaykoff.jd02_02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.stream.Collector;

class Queue {

    private static Deque<Buyer> instance = new LinkedList<>();

    private Queue() {
    }

    public static Deque<Buyer> getInstance() {
        return instance;
    }

    synchronized static void add(Buyer buyer) {
        instance.addLast(buyer);
    }

    synchronized static Buyer extract() {
        return instance.pollFirst();
    }

    synchronized static int length() {
        return instance.size();
    }
}
