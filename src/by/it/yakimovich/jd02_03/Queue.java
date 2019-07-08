package by.it.yakimovich.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Queue {

    private Queue() {
    }

    private static BlockingDeque<Buyer> instance = new LinkedBlockingDeque<>(30);

    static void add(Buyer buyer) {
        try {
            instance.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract(){
        return instance.pollFirst();
    }


}
