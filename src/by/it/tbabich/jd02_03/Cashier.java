package by.it.tbabich.jd02_03;

class Cashier implements Runnable {

    final static Object monitor = new Object();

    private String name;
    private ReceiptPrinter receiptPrinter;

    Cashier(int number) {
        name = "Cashier №" + number + " ";
        receiptPrinter = new ReceiptPrinter(number);
    }

    @Override
    public void run() {
        Dispatcher.cashierOpen();
        while (!Dispatcher.planComplete()) {
            Buyer buyer = PensionersQueue.extract();
            if (buyer == null) {
                buyer = Queue.extract();
            }
            if (buyer != null) {
                Backet backet = buyer.getBacket();
                synchronized (Dispatcher.console) {
                    System.out.println(this + "started service of " + buyer);
                    receiptPrinter.printCheck(backet.getProductList());
                }
                int timeout = Util.rnd(2000, 5000);
                Util.sleep(timeout);
                synchronized (Dispatcher.console) {
                    System.out.println(this + "stopped service of " + buyer);
                }
                synchronized (buyer) {
                    buyer.notifyAll();
                }
            } else {
                Dispatcher.cashierClose();
                synchronized (monitor) {
                    try {
                        monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
