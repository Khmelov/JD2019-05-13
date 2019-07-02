package by.it.dilkevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        int buyersNumberCount = 0;
        List<Buyer> buyers=new ArrayList<>();
        List<Cashier> cashiers = new ArrayList<>();

        System.out.println("Market opened");

        MainCashier cashier = runCashiers();
        runBuyers(buyersNumberCount, buyers);
        joinBuyers(buyers);
        joinCashier(cashier);

        System.out.println("Market closed");

    }

    private static void joinCashier(MainCashier cashiers) {
        try {
            cashiers.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static MainCashier runCashiers() {
            MainCashier cashier = new MainCashier(Integer.toString(1));
            cashier.start();
            return cashier;
    }

    private static void runBuyers(int buyersNumberCount, List<Buyer> buyers) {

        boolean pensioneer;
        int time = 1;

        while (Plan.getCountOfBuyers() < Dispatcher.NEDEED_BUYERS_COUNT) {

            int secondNow = time%60;
            int inputByers = getInputByers(buyersNumberCount, time, secondNow);;

            if(inputByers != 0) {

                for (int i = 0; i < inputByers; i++) {

                    while (Plan.getCountOfBuyers() < Dispatcher.NEDEED_BUYERS_COUNT) {
                        pensioneer = isPensioneer(buyersNumberCount);
                        Buyer buyer = new Buyer(String.valueOf(++buyersNumberCount), pensioneer);
                        buyer.start();
                        buyers.add(buyer);
                    }
                }
            }
            Util.sleep(1000);
            time++;
        }
    }

    private static int getInputByers(int buyersNumberCount, int time, int secondNow) {
        int inputByers;
        if (secondNow >=0 || secondNow <= 30){

            inputByers = time + 10 - buyersNumberCount;
        }
        else {

            inputByers = 40 + 30 - buyersNumberCount;
        }
        return inputByers;
    }

    private static boolean isPensioneer(int buyersNumberCount) {
        boolean pensioneer;
        if((buyersNumberCount+1) % 4 == 0) {
            pensioneer = true;
        }
        else {
            pensioneer = false;
        }
        return pensioneer;
    }

    private static void joinBuyers(List<Buyer> buyers) {
        for (Buyer buyer : buyers) {

            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
