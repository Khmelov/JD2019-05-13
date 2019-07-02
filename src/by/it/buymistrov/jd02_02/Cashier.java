package by.it.buymistrov.jd02_02;


class Cashier extends Thread {

    static final Object monitor = new Object();

    private int number;

    Cashier(int number) {
        super("Cashier №" + number);
        this.number = number;
        start();
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplete()) {
            Buyer buyer;
            synchronized (monitor) {
                buyer = Queue.extract();
            }
            if (buyer != null) {
                System.out.println(this + " started service of " + buyer);
                Util.sleep(Util.rnd(2000, 5000));
                Printer.print(this, buyer);
                System.out.println(this + " stopped service of " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else {
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
        return getName();
    }


    int getNumber() {
        return number;
    }
}
