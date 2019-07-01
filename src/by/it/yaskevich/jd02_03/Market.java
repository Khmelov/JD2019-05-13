package by.it.yaskevich.jd02_03;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Market {
    public static void main(String[] args) {
        printText("Магазин открыт");
        long startTime = System.currentTimeMillis();

        ExecutorService executorCashiers = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            executorCashiers.execute(new Cashier(i));
        }
        executorCashiers.shutdown();

        int number = 0;
        for (int time = 0; Dispatcher.marketIsOpened(); time++) {
            int buyersInSecondCount = getBuyersInSecondCount(time % 60);
            while ((buyersInSecondCount-- > 0) && Dispatcher.marketIsOpened()) {
                new Buyer(number++);
            }
            Utilities.sleep(1000);
            printText("В магазине на момент " + time + " вошло покупателей: " + Dispatcher.getBuyersInMarket());
        }

        while (!executorCashiers.isTerminated()) {
            Utilities.sleep(100);
        }

        printText("Магазин проработал: " + (System.currentTimeMillis() - startTime) + " м.с.");
        printText("Магазин закрыт");
        printText("Обслужено покупателей: " + Dispatcher.getBuyersCounter());
    }

    private static int getBuyersInSecondCount(int second) {
        if ((second >= 0) && ((second <= 30))) { // первые 30 секунд в минуте
            return (second + 10) - Dispatcher.getBuyersInMarket() - 1;
        } else if ((second > 30) && ((second <= 60))) { // вторые 30 секунд в минуте
            return (40 + (30 - second)) - Dispatcher.getBuyersInMarket();
        }
        return 0;
    }

    private static void printText(String text) {
        Printer.print(text);
    }
}
