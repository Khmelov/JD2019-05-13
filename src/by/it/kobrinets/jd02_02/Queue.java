package by.it.kobrinets.jd02_02;

import java.util.LinkedList;

class Queue {

    private static final LinkedList<Buyer> instance = new LinkedList<>();

    private static void printSize() {
        if (instance.size() > 0)
            System.out.println("Queue size: " + instance.size());
    }

    static void add(Buyer buyer) {
        synchronized (instance) {
            instance.addLast(buyer);
            printSize();
        }
    }

    static Buyer extract() {
        synchronized (instance) {
            Buyer buyer = instance.pollFirst();
            printSize();
            return buyer;
        }
    }

    static boolean buyerInQueue(Buyer buyer) {
        synchronized (instance) {
            return instance.indexOf(buyer) > -1;
        }
    }
}
