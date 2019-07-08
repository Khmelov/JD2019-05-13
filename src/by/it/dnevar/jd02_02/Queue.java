package by.it.dnevar.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

class Queue {

    private Queue() {
    }

    private static Deque<Buyer> buyersQueue = new LinkedList<>();
    private static Deque<Buyer> pensioneerQueue = new LinkedList<>();


    synchronized static void add(Buyer buyer) {
        if(buyer.getName().contains("pensioneer")) {
            buyersQueue.addLast(buyer);
        }else{
            pensioneerQueue.addLast(buyer);
        }
    }

    synchronized static Buyer extract(){
        if(pensioneerQueue.size()!=0) {
            return pensioneerQueue.pollFirst();
        }else{
            return buyersQueue.pollFirst();
        }
    }

    synchronized static int getQueueSize(){
        return buyersQueue.size()+pensioneerQueue.size();
    }


}
