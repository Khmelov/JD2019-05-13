package by.it.dilkevich.jd02_02;

import java.util.*;

public class MainCashier extends Thread {

    final static Object monitor = new Object();
    static List<MainCashier> cashiers = new ArrayList<>();
    static Map<Integer, Boolean> freeNumbers = new HashMap<>();
    public MainCashier(String name) {
        super("Кассир №" + name + "");
        Plan.setCountActiveCashiers();
    }




    @Override
    public void run() {


        System.out.println(this.getName() + " открыл кассу");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        while (Plan.getKlientsPayed()!= Plan.getCountOfBuyers()) {

            if (isNeedToAddCashier()) {
                System.out.println("запуск нового кассира");
                int countActiveCashiers = Plan.getCountActiveCashiers();
                Cashier cashier2 = new Cashier(Integer.toString(++countActiveCashiers));
                cashier2.start();
            }

            Buyer buyer = Queue.getBuyer();

            if (buyer != null) {
                synchronized (buyer) {

                    Plan.delKlientFromQueue();
                    Plan.setKlientsPayed();
                    System.out.println(this.getName() + " начал обслуживание " + buyer);
                    Util.sleep(Util.rnd(2000, 5000));
                    printBill(buyer);
                    buyer.notifyAll();
                    buyer.payForGoods();
                    System.out.println(this.getName() + " закончил обслуживание " + buyer);
                }
            } else if (buyer == null) {
                synchronized (MainCashier.monitor) {
                    try {
                        MainCashier.monitor.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println(this.getName() + " закрыл кассу");
    }

    private void printBill(Buyer buyer) {
        StringBuilder sb = new StringBuilder();
        Map<String, Double> goodsFromBacket = buyer.getGoodsFromBacket();
        Iterator<Map.Entry<String, Double>> iterator = goodsFromBacket.entrySet().iterator();

        sb.append(buyer).append("\n");
        while (iterator.hasNext()) {
            Map.Entry<String, Double> next = iterator.next();
            buyer.goodsCost += next.getValue();
            Buyer.buyersGoods.put(buyer.getName(),buyer.getGoodsFromBacket());
            sb.append(next.getKey()).append(": ").append(next.getValue()).append("\n");
        }
        addBillToCashBox(buyer);
        synchronized (buyer) {
            Buyer.sumForDay += buyer.goodsCost;
        }
        sb.append("Итого: " + buyer.goodsCost);
        System.out.println(sb);
        MoneyBox.printReport();
    }

    private void addBillToCashBox(Buyer buyer) {
        Double aDouble = MoneyBox.cashBoxJournal.get(getName());
        MoneyBox.cashBoxJournal.remove(getName());
        MoneyBox.cashBoxJournal.put(getName(),(aDouble+buyer.goodsCost));
    }

    private boolean isNeedToAddCashier(){

        synchronized (monitor){

            if (Plan.getCountActiveCashiers() == 1 && Plan.getKlientsInQueue() < 6 )
                return false;
            else if (Plan.getCountActiveCashiers() == 2 && Plan.getKlientsInQueue() > 5 && Plan.getKlientsInQueue() < 11 )
                return false;
            else if (Plan.getCountActiveCashiers() == 3 && Plan.getKlientsInQueue() > 10 && Plan.getKlientsInQueue() < 16 )
                return false;
            else if (Plan.getCountActiveCashiers() == 4 && Plan.getKlientsInQueue() > 15 && Plan.getKlientsInQueue() < 21 )
                return false;
            else if (Plan.getCountActiveCashiers() == 5 && Plan.getKlientsInQueue() > 20)
                return false;
            else return true;
        }

    }
}
