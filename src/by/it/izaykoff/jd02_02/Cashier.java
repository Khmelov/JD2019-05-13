package by.it.izaykoff.jd02_02;

class Cashier implements Runnable {

    final static Object monitor = new Object();

    private String name;

    Cashier(int number){
        name = "Cashier №" + number + " ";
    }

    @Override
    public void run() {
        while (!Dispatcher.planComplect()){
            Buyer buyer = Queue.extract();
            if (buyer != null){
                service(buyer);
                synchronized (buyer){
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

    private void service(Buyer buyer) {
        System.out.println(this + "started service of " + buyer);
        int timeout = Util.rnd(2000,5000);
        Util.sleep(timeout);
        System.out.println(this + "check goods " + buyer + " total: " );
        System.out.println(this + "stopped service of " + buyer);
    }

    @Override
    public String toString() {
        return name;
    }
}
