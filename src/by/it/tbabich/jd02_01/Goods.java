package by.it.tbabich.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer, String> goods = new HashMap<>();
    private static Map<Integer, Integer> prices = new HashMap<>();

    static {
        goods.put(1, "Хлеб");
        prices.put(1, 100);
        goods.put(2, "Молоко");
        prices.put(2, 200);
        goods.put(3, "Сахар");
        prices.put(3, 300);
        goods.put(4, "Соль");
        prices.put(4, 400);
        goods.put(5, "Водка");
        prices.put(5, 500);

    }

    static int getRandomGood() {
        int id = 1 + (int) (Math.random() * 5);
        return id;
    }

    static String getNameGood(int idGood){
        return goods.get(idGood);
    }

    static int getCostGood(int idGood){
        return prices.get(idGood);
    }

}
