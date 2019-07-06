package by.it.zhukova.jd02_03;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Queue {
    private Queue() {
    }
    private static BlockingDeque<Buyer> instance = new LinkedBlockingDeque<>(30);

   static void add(Buyer buyer) throws InterruptedException {
       instance.putLast(buyer);
   }

   static Buyer extract() {
       return instance.pollFirst();
   }

   static int size () { return instance.size();}
}
