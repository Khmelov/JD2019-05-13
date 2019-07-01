package by.it.yaskevich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Market {
    // to-do: классы занимаются тем, чем они не обязаны
    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        printText("Магазин открыт");
        startCashier(threads);
        int time = shoppingBuyers(threads);
        joinBuyersAndCashier(threads);
        printText("Магазин закрыт");
        printText("Обслужено покупателей: " + Dispatcher.getBuyersCounter());
        printText("Время работы магазина: " + time + " сек.");
    }

    private static void startCashier(List<Thread> threads) {
        for (int i = 0; i < 5/*2*/; i++) {
            threads.add(new Cashier(i));
        }
    }

    private static int shoppingBuyers(List<Thread> threads) {
        int number = 0;
        int time = 0;
        while (Dispatcher.marketIsOpened()) {
            int buyersInSecondCount = getBuyersInSecondCount(time % 60);
            while ((buyersInSecondCount-- > 0) && Dispatcher.marketIsOpened()) {
                threads.add(enterBuyer(number++));
            }
            Utilities.sleep(1000);

            printText("В магазине на момент " + time + " покупателей: " + Dispatcher.getBuyersInMarket());
            time++;
        }
        return time;
    }

    private static int getBuyersInSecondCount(int second) {
        if ((second >= 0 ) && ((second <= 30))) { // первые 30 секунд в минуте
            return (second + 10) - Dispatcher.getBuyersInMarket() - 1;
        }
        else if ((second > 30 ) && ((second <= 60))) { // вторые 30 секунд в минуте
            return (40 + (30 - second)) - Dispatcher.getBuyersInMarket();
        }
        return 0;
    }

    private static Buyer enterBuyer(int number) {
        return new Buyer(number);
    }

    private static void joinBuyersAndCashier(List<Thread> buyers) {
        for (Thread thread : buyers) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private static void printText(String text) {
        Printer.print(text);
    }
}
