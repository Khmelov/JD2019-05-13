package by.it.dilkevich.jd02_02;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Cashier extends Thread {

    public Cashier(String name) {
        super("Кассир №" + name + "");
        Plan.setCountActiveCashiers();
    }
    final static Object monitor = new Object();
    static List<Cashier> cashiers = new ArrayList<>();

    @Override
    public void run() {
        System.out.println(this.getName() + " открыл кассу");

        while (Plan.getKlientsPayed()!= Plan.getCountOfBuyers()) {

            if (isNeedToDellCashier()) {
                break;
            } else {
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
                    Plan.delCountActiveCashiers();
                    System.out.println(this.getName() + " закрыл кассу");
                    break;
                }
            }
        }
        Plan.delCountActiveCashiers();
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

    private synchronized void addBillToCashBox(Buyer buyer) {
        Double aDouble = MoneyBox.cashBoxJournal.get(getName());
        MoneyBox.cashBoxJournal.remove(getName());
        MoneyBox.cashBoxJournal.put(getName(),(aDouble+buyer.goodsCost));
    }

    private boolean isNeedToDellCashier(){

        synchronized (monitor){

            if (Plan.getCountActiveCashiers() > 1 && Plan.getKlientsInQueue() < 6 )
                return true;
            else if (Plan.getCountActiveCashiers() > 2 && Plan.getKlientsInQueue() > 5 && Plan.getKlientsInQueue() < 11 )
                return true;
            else if (Plan.getCountActiveCashiers() > 3 && Plan.getKlientsInQueue() > 10 && Plan.getKlientsInQueue() < 16 )
                return true;
            else if (Plan.getCountActiveCashiers() > 4 && Plan.getKlientsInQueue() > 15 && Plan.getKlientsInQueue() < 21 )
                return true;
            else if (Plan.getCountActiveCashiers() > 5 && Plan.getKlientsInQueue() > 20)
                return true;
            else return false;
        }

    }
}
