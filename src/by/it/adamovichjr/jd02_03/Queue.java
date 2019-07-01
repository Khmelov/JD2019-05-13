package by.it.adamovichjr.jd02_03;


import java.util.concurrent.ConcurrentLinkedDeque;

class Queue {

    private Queue() {
    }

    static ConcurrentLinkedDeque<Buyer> dequeBuyers = new ConcurrentLinkedDeque<>();
    static ConcurrentLinkedDeque<Buyer> dequePensionerBuyer = new ConcurrentLinkedDeque<>();
    static ConcurrentLinkedDeque<Cashier> dequeCashiersWait = new ConcurrentLinkedDeque<>();
    private static final int MAX_BUYERS_IN_MARKET_QUEUE = 30;
    private static ConcurrentLinkedDeque<Buyer>fakeQueue = new ConcurrentLinkedDeque<>();


    static void addBuyer(Buyer buyer) {
        if(dequeBuyers.size() + dequePensionerBuyer.size() > MAX_BUYERS_IN_MARKET_QUEUE){
            fakeQueue.addLast(buyer);
        }else {
            if (!buyer.pensioner) {
                dequeBuyers.addLast(buyer);
            } else {
                dequePensionerBuyer.addLast(buyer);
            }
        }
    }

    static Buyer extractBuyer() {
        if(dequeBuyers.size() + dequePensionerBuyer.size() < MAX_BUYERS_IN_MARKET_QUEUE && fakeQueue.size()>0){
            addBuyer(fakeQueue.pollFirst());
        }
        if (dequePensionerBuyer.size() > 0) {
            return dequePensionerBuyer.pollFirst();
        } else {
            return dequeBuyers.pollFirst();
        }
    }

    static void addCashier(Cashier cashier) {
        dequeCashiersWait.addLast(cashier);
    }

    static void extractCashier() {
        dequeCashiersWait.pollFirst();

    }

    static boolean needNewCashier() {
        return (Dispetcher.NUMBER_OF_CAHIRS - dequeCashiersWait.size()) * Dispetcher.BUERS_IN_QUEUE_PER_ONE_CASHIER < dequeBuyers.size() + dequePensionerBuyer.size() + Dispetcher.BUERS_IN_QUEUE_PER_ONE_CASHIER;
    }

    static boolean checkCashierOfBuyer() {
        return (Dispetcher.NUMBER_OF_CAHIRS - dequeCashiersWait.size()) * Dispetcher.BUERS_IN_QUEUE_PER_ONE_CASHIER < dequeBuyers.size() + dequePensionerBuyer.size();
    }


}
