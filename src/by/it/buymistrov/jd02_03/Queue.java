package by.it.buymistrov.jd02_03;


import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.Semaphore;

class Queue {

    private static Semaphore semaphore = new Semaphore(30);

    private static BlockingDeque<Buyer> queue = new LinkedBlockingDeque<>(30);
    private static BlockingDeque<Buyer> queuePens = new LinkedBlockingDeque<>(30);


    private Queue() {
    }

    synchronized static void add(Buyer buyer) {
        try {
            semaphore.acquire();
            if (buyer.isPensioner()) {
                queuePens.putLast(buyer);
            } else {
                queue.putLast(buyer);
            }
        } catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    synchronized static Buyer extract() {
        try {
            if (!(queuePens.isEmpty())) {
                return queuePens.pollFirst();
            } else {
                return queue.pollFirst();
            }
        } finally {
            semaphore.release();
        }
    }

    synchronized static int length() {
        return queuePens.size() + queue.size();
    }
}
