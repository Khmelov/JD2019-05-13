package by.it.tbabich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class PensionersQueue {

    private PensionersQueue() {
    }

    private static Deque<Buyer> instance = new LinkedList<>();

    synchronized static void add(Buyer buyer) {
        instance.addLast(buyer);
    }

    synchronized static Buyer extract(){
        return instance.pollFirst();
    }

    synchronized static int getQueueSize(){
        return instance.size();
    }


}
