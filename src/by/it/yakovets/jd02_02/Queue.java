package by.it.yakovets.jd02_02;

import java.util.Deque;
import java.util.LinkedList;


public class Queue {


    private Queue() {

    }

    private final static Deque<Buyer> instance = new LinkedList<>();
    private final static Deque<Cashier> cashiers = new LinkedList<>();


    synchronized static void add (Buyer buyer) {
        instance.addLast(buyer);

    }

    synchronized static Buyer extract(){
        return instance.pollFirst();

    }

    synchronized static void addCashier (Cashier cashier) {
        cashiers.addLast(cashier);

    }

    synchronized static Cashier extractCashier(){
        return cashiers.pollFirst();
    }

    synchronized static int cashiersSize(){
        return cashiers.size();
    }
    synchronized static boolean cashiersNeed(){
        return true;
    }

}