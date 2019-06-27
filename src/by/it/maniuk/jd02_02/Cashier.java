package by.it.maniuk.jd02_02;

public class Cashier implements Runnable {
    private String name;

   final static Object monitor = new Object();

    @Override
    public void run() {
        while (!Dispatcher.planComplete()){
       Buyer buyer = Queue.extract();
        if (buyer!=null){
            System.out.println(this+" Stand service of "+ buyer);
           int timeout =  Util.rnd(2000, 5000);
            System.out.println(this+" stopped service for "+ buyer);
        }
        else {
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
