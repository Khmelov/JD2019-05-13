package by.it.trudnitski.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queue {

    private static Deque<Buyer> instance = new LinkedList<Buyer>();


    synchronized static void add(Buyer buyer) {
        instance.addLast(buyer);
    }

    synchronized static Buyer extract() {
        return instance.pollFirst();
    }

    synchronized static int getSize() {
        return instance.size();
    }

    private static int cashierNow = 0;

    synchronized static int lenght() {
        return instance.size();
    }
}
