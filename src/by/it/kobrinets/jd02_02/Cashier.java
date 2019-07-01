package by.it.kobrinets.jd02_02;

public class Cashier implements Runnable {

    private int number;

    Cashier(int number) {
        this.number = number;
    }

    @Override
    @SuppressWarnings("SynchronizationOnLocalVariableOrMethodParameter")
    public void run() {
        System.out.println(this + " opened");
        while (!Dispatcher.planComplete()) {
            Buyer buyer = Queue.extract();
            if (buyer != null) {
                System.out.println(this + " started service of " + buyer);
                int timeout = Util.rnd(2000, 5000);
                Util.sleep(timeout);
                System.out.println(this + " stopped service of " + buyer);
                synchronized (buyer) {
                    buyer.notify();
                }
            } else
                Util.sleep(100);
        }

        System.out.println(this + " closed");
    }

    @Override
    public String toString() {
        return "Cashier №" + number;
    }
}