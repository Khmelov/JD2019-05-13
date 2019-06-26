package by.it.yakovets.jd02_02;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Queue {


    private Queue() {

    }

    private final static Deque<Buyer> instance = new LinkedList<>();

    synchronized static void add (Buyer buyer) {
        instance.addLast(buyer);

    }

    synchronized static Buyer extract(){
         return instance.pollFirst();
    }
}
