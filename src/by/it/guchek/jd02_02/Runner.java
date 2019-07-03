package by.it.guchek.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Runner {


    public static void main(String[] args) {
        List<Thread> threads=new ArrayList<>();
        System.out.println("Магазин открыт");

        for (int i = 0; i <2 ; i++) {                //запускаем поток кассиров

            Thread thread = new Thread(new Cashier(i));
            threads.add(thread);
            thread.start();

        }

        int numberBuyer=0;
        while (Dispatcher.marketIsOpened()) {

            int count = 0;
            for (int sec = 0; sec < 60; sec++) {

                if ((sec <= 30) && (sec % 3 == 0)) {

                    count = RandCount.randFrTo(2);

                } else if ((sec > 30) && (sec % 2 == 0)) {

                    count = RandCount.randFrTo(2);

                } else if ((sec > 30) && (sec % 3 == 0)) {

                    count = RandCount.randFrTo(1);
                }
            }



            for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) { //добавили в условие проверку открыты ли
                Buyer buyer = new Buyer(++numberBuyer);
                buyer.start();
                threads.add(buyer);
            }

            RandCount.sleep(1000);
        }


        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Магазин закрыт");
    }
}
