package by.it.orlov.jd02_02;

import java.util.*;

class Queue {

    private static final Deque<Buyer> buyerQueue = new LinkedList<>();
    private static final Deque<Buyer> pensionerQueue = new LinkedList<>();

    static Buyer getBuyerFromQueue() {
        synchronized (buyerQueue) {
            if (pensionerQueue.size() != 0)
                return pensionerQueue.poll();
            else
                return buyerQueue.poll();
        }
    }

    static void addBuyerToQueue(Buyer buyer) {
        synchronized (pensionerQueue) {
            if (buyer.isPensioner()) pensionerQueue.add(buyer);
            else buyerQueue.add(buyer);
        }
    }

    static int getQueueSize() {
        synchronized (pensionerQueue) {
            return buyerQueue.size() + pensionerQueue.size();
        }
    }

    private static int cashiersClosed = 0;

    static synchronized void cashierOpens() {
        cashiersClosed--;
    }

    static synchronized void cashierCloses() {
        cashiersClosed++;
    }

    static synchronized int cashierInWork() {
        return Cashier.cashiersMaxLimit - cashiersClosed;
    }

}
