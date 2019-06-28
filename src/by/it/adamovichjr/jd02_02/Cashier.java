package by.it.adamovichjr.jd02_02;


import java.util.ArrayList;

public class Cashier extends Thread {

    final static Object monitor = new Object();


    Cashier(int number) {
        setName("Cashier №" + number);
        start();
        numbersOfSpaces = (number-1)*columnsWidth;
    }
    private static final int columnsWidth = 20;
    private static final int lastColumnsWidth = 10;
    private final int numbersOfSpaces;
    private StringBuilder sb = new StringBuilder();
    private static int totalSumInChecks = 0;

    @Override
    public void run() {
        while (!Dispetcher.planComplete()) {
            if (Queue.needNewCashier()) {
                Buyer buyer = Queue.extractBuyer();
                System.out.println(this + " started service of " + buyer);
                printCheckOfBuyer(buyer);
                int timeout = Time.fromTo(2000, 5000);
                Time.sleep(timeout);
                System.out.println(this + "stopped service of " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
                synchronized (monitor) {
                    try {
                        Queue.addCashier(this);
                        System.out.println(this + " closed");
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }

    private void printCheckOfBuyer(Buyer buyer) {

        ArrayList<String> courentBuyerBacket = new ArrayList<>(buyer.backet.backetWithGoods);
        int sumOfCheck = countSumOfCheck(courentBuyerBacket);

        sb.delete(0,sb.length());
        String spaces = createProbelsForColumn(numbersOfSpaces);
        sb.append("\n").append(spaces).append(this);
        String spacesForQueueColumn = createProbelsForColumn(Dispetcher.numberOfCashier*columnsWidth - (sb.length()-1));
        int queueSize = Queue.dequeBuyers.size() + Queue.dequePensionerBuyer.size();
        sb.append(spacesForQueueColumn).append("Queue: ").append(queueSize);
        String spacesForTotalSum = createProbelsForColumn(Dispetcher.numberOfCashier*columnsWidth + lastColumnsWidth - (sb.length()-1));
        synchronized (monitor){
            totalSumInChecks +=sumOfCheck;
            sb.append(spacesForTotalSum).append("Total Sum: ").append(totalSumInChecks).append("\n");
        }
        for (int i = 1; i <= courentBuyerBacket.size(); i++) {
            sb.append(spaces).append("№").append(i).append(" ").append(courentBuyerBacket.get(i - 1)).append(" Price: ").append(Goods.goods.get(courentBuyerBacket.get(i-1))).append("\n");
        }

        sb.append(spaces).append("Sum of check: ").append(sumOfCheck).append("\n");
        System.out.println(sb);
        sb.delete(0,sb.length());
    }
    private int countSumOfCheck(ArrayList<String>backet){
        int result = 0;
        for (String s : backet) {
            result += Goods.goods.get(s);
        }
        return result;
    }

    private String createProbelsForColumn(int numberOfSpaces) {
        for (int i = 0; i < numberOfSpaces; i++) {
            sb.append(" ");
        }
        final String probels = sb.toString();
        sb.delete(0,sb.length());
        return probels;
    }


    @Override
    public String toString() {
        return this.getName();
    }
}
