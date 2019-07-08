package by.it.livanovich.jd02_03;

public class Cashier implements Runnable{
    static final Object monitor=new Object();
    private String name;

    Cashier(int number) {
        name = "Кассир №" + number + " ";
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public void run() {
        while (!Dispatcher.planIsDone()){
            Buyer buyer= Queue.deductBuyer();
            if (buyer!=null){
                System.out.println(this+"начал обслуживать "+buyer);
                int timeout= Rnd.Rnd(2000,5000);
                Rnd.sleep(timeout);
                System.out.println("В корзине " + buyer + ": ");
                double sum = 0;
                Good good;
                while ((good = buyer.getBacket().extractBasket()) != null) {
                    System.out.println(good);
                    sum += good.getPrice();
                }
                System.out.printf("Итого: %4.2f\n", sum);
                System.out.println(this + "закончил обслуживать " + buyer);
                synchronized (buyer){
                    buyer.setWait(false);
                    buyer.notifyAll();
                }
            }
            else synchronized (monitor){
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
