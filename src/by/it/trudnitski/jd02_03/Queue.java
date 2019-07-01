package by.it.trudnitski.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Queue {

    private static BlockingDeque<Buyer> instance = new LinkedBlockingDeque<>();


    synchronized static void add(Buyer buyer) {
        instance.addLast(buyer);
    }

    synchronized static Buyer extract() {
        return instance.pollFirst();
    }

    synchronized static int getSize() {
        return instance.size();
    }

    synchronized static int lenght() {
        return instance.size();
    }
}
