package by.it.aadamovich.jd02_03;

import java.util.Comparator;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

class Queue {

    private static Comparator<Buyer> pensionerComparator = (c1, c2) -> {
        if (c1.isPensioner() && !c2.isPensioner()) {
            return -1;
        } else if (!c1.isPensioner() && c2.isPensioner()) {
            return 1;
        } else if (c1.getTimeJoinQueue() < c2.getTimeJoinQueue()) {
            return -1;
        } else if (c1.getTimeJoinQueue() > c2.getTimeJoinQueue()) {
            return 1;
        }
        return 0;
    };

    private static PriorityBlockingQueue<Buyer> buyerQueue = new PriorityBlockingQueue<>(30, pensionerComparator);

    static Buyer getBuyerFromQueue() {
        return buyerQueue.poll();
    }

    static void addBuyerToQueue(Buyer buyer) {
        buyerQueue.offer(buyer);
    }

    static int getQueueSize() {
        return buyerQueue.size();
    }


    private static final AtomicInteger cashiersClosed = new AtomicInteger(0);

    static void cashierOpens() {
        cashiersClosed.getAndDecrement();
    }

    static void cashierCloses() {
        cashiersClosed.getAndIncrement();
    }

    static int cashierInWork() {
        return Cashier.CASHIERS_MAX_LIMIT - cashiersClosed.get();
    }
}
