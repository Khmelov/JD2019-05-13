package by.it.trudnitski.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

class Queue {
    private static Semaphore semaphore = new Semaphore(30);

    private static BlockingDeque<Buyer> instance = new LinkedBlockingDeque<>();


    static void add(Buyer buyer) {
        try {
            semaphore.acquire();
            instance.addLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract() {
        try {
            return instance.pollFirst();
        } finally {
            semaphore.release();
        }
    }

    synchronized static int getSize() {
        return instance.size();
    }

    synchronized static int lenght() {
        return instance.size();
    }
}
