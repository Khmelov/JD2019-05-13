package by.it.izaykoff.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Queue {

    private static BlockingDeque<Buyer> instance = new LinkedBlockingDeque<>(30);

    private Queue() {
    }

    static void add(Buyer buyer) {
        try {
            instance.putLast(buyer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract() {
            return instance.pollFirst();
        }

    static int length() {
        return instance.size();
    }
}
