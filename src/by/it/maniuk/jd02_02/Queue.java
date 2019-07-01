package by.it.maniuk.jd02_02;


import java.util.Deque;
import java.util.LinkedList;


public class Queue {

    private Queue(){
    }

    private static Deque<Buyer> instance = new  LinkedList<>();
    private static Deque<Cashier> cashiers = new LinkedList<>();
    private static Deque<Cashier> pensionner = new LinkedList<>();

   synchronized static void addBuyer(Buyer buyer){
        instance.addLast(buyer);
       System.out.println(buyer + " stood in line");
    }

    synchronized static Buyer extractBuyer(){
       return instance.pollFirst();
    }

    synchronized static int sizeInstance(){
       return instance.size();
    }

    synchronized static void addCashier(Cashier cashier){
        cashiers.addLast(cashier);
    }

    synchronized static int sizeCashiers(){
       return cashiers.size();
    }
    synchronized static Cashier extractCashier(){
        return cashiers.pollFirst();

    }

    synchronized static void dellCashiers(Cashier cashier){
       cashiers.remove(cashier);
    }
    synchronized static boolean needCashier() {
        return (Dispatcher.getCashierNumber() - sizeCashiers()) * 5 < (sizeInstance() + pensionner.size() + 5);
    }

    synchronized static boolean checkCashierOfBuyer() {
        return (Dispatcher.getCashierNumber() - sizeCashiers()) * 5 < sizeInstance() + pensionner.size();
    }

}
