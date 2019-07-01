package by.it.guchek.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Runner {


    public static void main(String[] args) {
        List<Thread> threads=new ArrayList<>();
        System.out.println("Магазин открыт");
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 2; i++) {                //запускаем поток кассиров
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();

        int numberBuyer=0;
        while (Dispatcher.marketIsOpened()){
            int count= RandCount.randFrTo(2);
            for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) { //добавили в условие проверку открыты ли
                Buyer buyer=new Buyer(++numberBuyer);
                buyer.start();
            }
            RandCount.sleep(1000);
        }


        while (!executorService.isTerminated()) {
            RandCount.sleep(100);
        }
        System.out.println("Магазин закрыт");
    }
}
