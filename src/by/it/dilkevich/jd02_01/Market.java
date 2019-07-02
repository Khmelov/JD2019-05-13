package by.it.dilkevich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Market {

    public static void main(String[] args) {

        int buyersNumberCount = 0;
        List<Buyer> buyers=new ArrayList<>();
        System.out.println("Market opened");
        runTread(buyersNumberCount, buyers);
        join(buyers);
        System.out.println("Market closed");

    }

    private static void runTread(int buyersNumberCount, List<Buyer> buyers) {

        boolean pensioneer;

        for (int time = 1; time < 121; time++) {

            int secondNow = time%60;
            int inputByers = getInputByers(buyersNumberCount, time, secondNow);;

            if(inputByers != 0) {

                for (int i = 0; i < inputByers; i++) {

                    pensioneer = isPensioneer(buyersNumberCount);
                    Buyer buyer = new Buyer(String.valueOf(++buyersNumberCount), pensioneer);
                    buyer.start();
                    buyers.add(buyer);
                }
            }

            Util.sleep(1000);
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

    private static void join(List<Buyer> buyers) {
        for (Buyer buyer : buyers) {

            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
