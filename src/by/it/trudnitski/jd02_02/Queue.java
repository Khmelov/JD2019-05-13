package by.it.trudnitski.jd02_02;

import java.util.Deque;
import java.util.LinkedList;

public class Queue {

    private Queue(){

    }

    private final static Deque<Buyer> instance= new LinkedList<Buyer>();



    synchronized static void add(Buyer buyer){
        instance.addLast(buyer);
    }
    synchronized static Buyer extract(){
        return instance.pollFirst();
    }
}
