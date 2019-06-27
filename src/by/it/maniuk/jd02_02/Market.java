package by.it.maniuk.jd02_02;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Market {

    public static void main(String[] args) {
        List<Thread> threads=new ArrayList<>();
        List<Buyer> buyers=new ArrayList<>();
        List<String> times=new ArrayList<>();
        System.out.println("Market opened");

        for (int i = 0; i <2 ; i++) {
           Thread thread = new Thread(new Cashier(i));
            threads.add(thread);
            thread.start();
        }

        int numberBuyer=0;
        while (!Dispatcher.marketIsOpened()){
            int count = Util.rnd(2);
            for (int i = 0; i < count&& Dispatcher.marketIsOpened(); i++) {
                Buyer buyer = new Buyer(++ numberBuyer);
                buyer.start();
                buyers.add(buyer);
                //times.add(new Date().toString());
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

        for (String taim : times) {
            System.out.println(taim);
        }
    }
}
