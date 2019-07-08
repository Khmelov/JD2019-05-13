package by.it.zhukova.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        System.out.println("Market opened");
         ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorService.execute(new Cashier(i));
        }
        executorService.shutdown();
        int numberBuyer = 0;
        boolean pensioneer;
        while (Dispatcher.marketIsOpened()) {
            int count = Util.rnd(2);
            for (int min = 0; min < 2; min++) {
                for (int time = 0; time < 60; time++) {
                    int N = Dispatcher.getBuyerInMarket().get();
                    if ((time > 30) && (N > 40 + (30 - time))) {
                        count = 0;
                    }
                    for (int i = 0; i < count && Dispatcher.marketIsOpened(); i++) {
                        ++numberBuyer;
                        if (numberBuyer % 4 == 0) {
                            pensioneer = true;
                        } else {
                            pensioneer = false;
                        }
                        Buyer buyer = new Buyer(numberBuyer, pensioneer);
                        buyer.start();
                    }
                    Util.sleep(1000);
                }
            }
        }
       while (!executorService.isTerminated()) {Util.sleep(200);}
        System.out.println("Market closed");
}
}
