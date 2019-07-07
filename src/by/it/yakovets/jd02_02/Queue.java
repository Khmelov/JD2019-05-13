package by.it.yakovets.jd02_02;

import java.util.Deque;
import java.util.LinkedList;


public class Queue {


    private Queue() {

    }

    private final static Deque<Buyer> buyers = new LinkedList<>();
    private final static Deque<Cashier> cashiers = new LinkedList<>();


    synchronized static void add (Buyer buyer) {
        buyers.addLast(buyer);

    }

    synchronized static Buyer extract(){
        return buyers.pollFirst();

    }

    synchronized static void addCashier (Cashier cashier) {
        cashiers.addLast(cashier);

    }

    synchronized static Cashier extractCashier(){
        return cashiers.pollFirst();
    }


    synchronized static boolean cashiersNeed(){
        return (Dispatcher.cashierscount-cashiers.size())*5 < (buyers.size()+5);
    }
    synchronized static boolean countCashiersPerBuyer() {
        return (Dispatcher.cashierscount - cashiers.size()) * 5 < buyers.size();
    }
}