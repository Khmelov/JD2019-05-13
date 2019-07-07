package by.it.dnevar.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Queue {

    private Queue() {
    }

    private static BlockingDeque<Buyer> buyersQueue = new LinkedBlockingDeque<>(25);
    private static BlockingDeque<Buyer> pensioneerQueue = new LinkedBlockingDeque<>(5);


    static void add(Buyer buyer) {
        try {
            if (buyer.getName().contains("pensioneer")) {
                buyersQueue.putLast(buyer);
            } else {
                pensioneerQueue.putLast(buyer);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    static Buyer extract(){
        if(pensioneerQueue.size()!=0) {
            return pensioneerQueue.pollFirst();
        }else{
            return buyersQueue.pollFirst();
        }
    }

    static int getQueueSize(){
        return buyersQueue.size()+pensioneerQueue.size();
    }


}
