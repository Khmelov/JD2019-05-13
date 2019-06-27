package by.it.trudnitski.jd02_02;

public class Cashier implements Runnable {
    static final Object monitor=new Object();
    private String name;

    public Cashier(int number){
        name="Cashier #"+number +" ";
    }

    @Override
    public String toString() {
        return super.toString();
    }

    @Override
    public void run() {
        while (Dispatcher.planComplete()) {
            Buyer buyer=Queue.extract();
            if (buyer != null) {
                System.out.println(this + "start service of" + buyer);
                int timeout = Helper.randomeGet(2000, 5000);
                Helper.sleep(timeout);
                System.out.println(this + "stopped service of" + buyer);
                synchronized (buyer){
                    buyer.notifyAll();

                }            } else {
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
}
