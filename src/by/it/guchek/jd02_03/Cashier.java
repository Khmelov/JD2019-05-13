package by.it.guchek.jd02_03;

public class Cashier implements Runnable {
    final static Object monitor = new Object();

    private String name;

    Cashier(int number) {
        name = "Cashier №" + (number+1) + " ";
    }

    @Override
    //SynchronizationOnLocalVariableOrMethodParameter/
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer = Queue.extract();
            if (buyer != null) {
                System.out.println(this + "started service of " + buyer);
                int timeout = RandCount.randFrTo(2000, 5000);
                buyer.bucket.readGood(buyer.getName());
                printBill(buyer);
                RandCount.sleep(timeout);
                System.out.println(this + "stopped service of " + buyer);
                synchronized (buyer){
                    buyer.setFlagWait(false);
                    buyer.notifyAll();
                }
            } else {
                synchronized (monitor){
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private synchronized void printBill(Buyer buyer) {
        int countT = buyer.bucket.goodListsize();
        double countBill = 0;
        System.out.println();
        System.out.println("  ****** ЧЕК ******  ");
        buyer.bucket.readGoodForBill(buyer.getName());
        for (int i = 0; i < countT; i++) {

            countBill = countBill + (buyer.bucket.getOutOfBucket().getPrice());

        }
        System.out.printf("ИТОГО:       %5.2f руб.%n", countBill);
        System.out.println("-----------------------");
        System.out.println("            " + this.name);
        System.out.println();
    }

    @Override
    public String toString() {
        return name;
    }
}
