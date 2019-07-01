package by.it.buymistrov.jd02_02;


import java.util.Deque;
import java.util.LinkedList;

class Queue {
    private static final Deque<Buyer> queue = new LinkedList<>();
    private static final Deque<Buyer> queuePens = new LinkedList<>();

    private Queue() {
    }

    synchronized static void add(Buyer buyer) {
        if (buyer.isPensioner()) {
            queuePens.addLast(buyer);
        } else {
            queue.addLast(buyer);
        }
    }

    synchronized static Buyer extract() {
        if (!(queuePens.isEmpty())) {
            return queuePens.pollFirst();
        } else {
            return queue.pollFirst();
        }
    }

    synchronized static int length() {
        return queuePens.size() + queue.size();
    }
}
