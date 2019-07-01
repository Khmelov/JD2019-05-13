package by.it.maniuk.jd02_03;



import java.util.concurrent.*;


public class Queue {

    private Queue(){
    }

    private static BlockingDeque<Buyer> instance = new LinkedBlockingDeque<>(30);
    private static BlockingDeque<Cashier> cashiers = new LinkedBlockingDeque<>();
    private static BlockingDeque<Cashier> pensionner = new LinkedBlockingDeque<>();

   public static void addBuyer(Buyer buyer){
       try {
           instance.putLast(buyer);
       } catch (InterruptedException e) {
           e.printStackTrace();
       }
       System.out.println(buyer + " stood in line");
    }

     static Buyer extractBuyer(){
       return instance.pollFirst();
    }

    private static int sizeInstance(){
       return instance.size();
    }

     static void addCashier(Cashier cashier){
        cashiers.add(cashier);
    }

   private static int sizeCashiers(){
       return cashiers.size();
    }
   static void extractCashier(){
       cashiers.poll();

    }

    synchronized static void dellCashiers(Cashier cashier){
       cashiers.remove(cashier);
        System.out.println(cashier + " in rest");
    }
    synchronized static boolean needCashier() {
        return (Dispatcher.getCashierNumber() - sizeCashiers()) * 5 < (sizeInstance() + pensionner.size() + 5);
    }

    synchronized static boolean checkCashierOfBuyer() {
        return (Dispatcher.getCashierNumber() - sizeCashiers()) * 5 < sizeInstance() + pensionner.size();
    }

}
