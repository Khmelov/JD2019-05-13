package by.it.aadamovich.jd02_02;

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
        synchronized (buyerQueue) {
            if (buyer.isPensioner()) pensionerQueue.add(buyer);
            else buyerQueue.add(buyer);
        }
    }

    static int getQueueSize() {
        synchronized (buyerQueue) {
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

//    private static Comparator<Buyer> idComparator = new Comparator<Buyer>() {
//
//        @Override
//        public int compare(Buyer c1, Buyer c2) {
//            if (c1.isPensioner() && !c2.isPensioner()) {
//                return -1;
//            } else if (c1.isPensioner() && c2.isPensioner()) {
//                return 0;
//            }else if (!c1.isPensioner() && c2.isPensioner()) {
//                return 1;
//            } else if (!c1.isPensioner() && !c2.isPensioner()) {
//            return 0;
//        }
//            return 0;
//        }
//    };
//    private static PriorityQueue<Buyer> buyerQueue = new PriorityQueue<>(idComparator);
}
