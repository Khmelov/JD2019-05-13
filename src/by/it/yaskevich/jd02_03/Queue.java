package by.it.yaskevich.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

class Queue {
    private static final int MAX_LENGTH_QUEUE = 30;

    private static Semaphore queue = new Semaphore(MAX_LENGTH_QUEUE);
    private static BlockingDeque<Buyer> commonQueue = new LinkedBlockingDeque<>(MAX_LENGTH_QUEUE);
    private static BlockingDeque<Buyer> pensionersQueue = new LinkedBlockingDeque<>(MAX_LENGTH_QUEUE);

    private Queue() {
    }

    static void add(Buyer buyer) {
        try {
            queue.acquire();
            if (buyer.isPensioner()) {
                pensionersQueue.putLast(buyer);
            } else {
                commonQueue.putLast(buyer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract() {
        try {
            return !pensionersQueue.isEmpty() ? pensionersQueue.pollFirst() : commonQueue.pollFirst();
        } finally {
            queue.release();
        }
    }

    static int length() {
        return pensionersQueue.size() + commonQueue.size();
    }
}
