package by.it.yaskevich.jd02_01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Market {
    static boolean printStatesBuyer = false; //печать состаяний покупателя
    static List<Buyer> shoppingBuyers =
            Collections.synchronizedList(new ArrayList<Buyer>(40));
    private static int countAllBuyers = 0;

    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>();

        System.out.println("Магазин открыт");
        shoppingBuyers(buyers);
        joinBuyers(buyers);
        System.out.println("Магазин закрыт");
        System.out.println("Магазин обслужил покупателей: " + countAllBuyers);
    }

    private static void shoppingBuyers(List<Buyer> buyers) {
        for (int time = 0; time < 120; time++) {
            int second = time % 60;
            int countBuyersSecond = 0;
            if ((second >= 0 ) && ((second <= 30))) { // первые 30 секунд в минуте
                countBuyersSecond = Utilities.rnd(2) + (second + 10) - shoppingBuyers.size();
            }
            else if ((second > 30 ) && ((second <= 60))) { // вторые 30 секунд в минуте
                countBuyersSecond = (40 + (30 - second)) - shoppingBuyers.size();
            }
            while (countBuyersSecond-- >= 0) {
                buyers.add(enterBuyer());
            }
            Utilities.sleep(1000);
            System.out.println("В магазине на момент " + time + " покупателей: " + shoppingBuyers.size());
        }
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

    private static Buyer enterBuyer() {
        Buyer buyer = new Buyer(++countAllBuyers);
        buyer.setPensioner(countAllBuyers % 4 == 0);
        buyer.start();
        return buyer;
    }
}
