package by.it.izaykoff.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queue {

    private Queue() {
    }
    private static Deque<Buyer> instance = new LinkedList<>();

    synchronized static void add(Buyer buyer){
        instance.addLast(buyer);
    }
    synchronized static Buyer extract(){
        return instance.pollFirst();
    }
}
