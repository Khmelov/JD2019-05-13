package by.it.yaskevich.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queue {
    private static final Deque<Buyer> commonQueue = new LinkedList<>();
    private static final Deque<Buyer> pensionersQueue = new LinkedList<>();

    private Queue() {}

    synchronized static void add(Buyer buyer) {
        if (buyer.isPensioner()) {
            pensionersQueue.addLast(buyer);
        }
        else {
            commonQueue.addLast(buyer);
        }
    }

    synchronized static Buyer extract(){
        return !pensionersQueue.isEmpty() ? pensionersQueue.pollFirst() : commonQueue.pollFirst();
    }

    synchronized static int length() {
        return pensionersQueue.size() + commonQueue.size();
    }
}
