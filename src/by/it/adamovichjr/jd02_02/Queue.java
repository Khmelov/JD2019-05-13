package by.it.adamovichjr.jd02_02;


import java.util.Deque;
import java.util.LinkedList;

class Queue {

    private Queue() {
    }

    static Deque<Buyer> dequeBuyers = new LinkedList<>();
    static Deque<Buyer> dequePensionerBuyer = new LinkedList<>();
    static Deque<Cashier> dequeCashiersWait = new LinkedList<>();


    synchronized static void addBuyer(Buyer buyer) {
        if (!buyer.pensioner) {
            dequeBuyers.addLast(buyer);
        } else {
            dequePensionerBuyer.addLast(buyer);
        }
    }

    synchronized static Buyer extractBuyer() {
        if (dequePensionerBuyer.size() > 0) {
            return dequePensionerBuyer.pollFirst();
        } else {
            return dequeBuyers.pollFirst();
        }
    }

    synchronized static void addCashier(Cashier cashier) {
        dequeCashiersWait.addLast(cashier);
    }

    synchronized static void extractCashier() {
        dequeCashiersWait.pollFirst();

    }

    synchronized static boolean needNewCashier() {
        return (Dispetcher.numberOfCashier - dequeCashiersWait.size()) * Dispetcher.buersInQueuePerOneCashier < dequeBuyers.size() + dequePensionerBuyer.size() + Dispetcher.buersInQueuePerOneCashier;
    }

    synchronized static boolean checkCashierOfBuyer() {
        return (Dispetcher.numberOfCashier - dequeCashiersWait.size()) * Dispetcher.buersInQueuePerOneCashier < dequeBuyers.size() + dequePensionerBuyer.size();
    }


}
