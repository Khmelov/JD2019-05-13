package by.it.maniuk.jd02_02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        List<Buyer> buyers=new ArrayList<>();
        List<String> taims=new ArrayList<>();
        System.out.println("Market opened");
        int numberBuyer=0;

        for (int i = 0; i <2 ; i++) {
           Thread thread = new Thread(new Cashier());

        }


        while (!Dispatcher.marketIsOpend()){
            int count = Util.rnd(2);
            for (int i = 0; i < count&& Dispatcher.marketIsOpend(); i++) {
                Buyer buyer = new Buyer(++ numberBuyer);
                buyer.start();
                buyers.add(buyer);
                taims.add(new Date().toString());
            }

            Util.sleep(1000);
        }
        for (Buyer buyer : buyers) {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Market closed");

        for (String taim : taims) {
            System.out.println(taim);
        }
    }
}
