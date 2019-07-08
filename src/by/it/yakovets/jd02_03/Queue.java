package by.it.yakovets.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.ConcurrentLinkedDeque;


public class Queue {


    private Queue() {

    }

    static ConcurrentLinkedDeque<Buyer> buyers = new ConcurrentLinkedDeque<>();
    static ConcurrentLinkedDeque<Buyer> fakeBuyers = new ConcurrentLinkedDeque<>();
    static ConcurrentLinkedDeque<Cashier> cashiers = new ConcurrentLinkedDeque<>();
    private static final int LIMIT_BUYERS = 30;

    static void add(Buyer buyer) {
        if (buyers.size() > LIMIT_BUYERS) {
            fakeBuyers.addLast(buyer);
        } else {
            buyers.addLast(buyer);
        }
    }

    static Buyer extract() {
        if (buyers.size() < LIMIT_BUYERS && fakeBuyers.size() > 0) {
            Buyer fakeBuyer = fakeBuyers.pollFirst();
            add(fakeBuyer);
        }

        return buyers.pollFirst();


    }

    static void addCashier(Cashier cashier) {
        cashiers.addLast(cashier);

    }

    static void extractCashier() {
         cashiers.pollFirst();
    }


    static boolean cashiersNeed() {
        return (Dispatcher.cashierscount - cashiers.size()) * 5 < buyers.size() + 5;
    }

    static boolean countCashiersPerBuyer() {
        return (Dispatcher.cashierscount - cashiers.size()) * 5 < buyers.size();
    }
}