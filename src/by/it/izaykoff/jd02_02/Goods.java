package by.it.izaykoff.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer, String> goods = new HashMap<>();
    private static Map<String, Double> priceOfTheGoods = new HashMap<>();

    static {
        goods.put(1, "Bread");
        priceOfTheGoods.put("Bread", 2.0);
        goods.put(2, "Milk");
        priceOfTheGoods.put("Milk", 2.5);
        goods.put(3, "Sugar");
        priceOfTheGoods.put("Sugar", 4.2);
        goods.put(4, "Sold");
        priceOfTheGoods.put("Sold", 1.5);
        goods.put(5, "Vodka");
        priceOfTheGoods.put("Vodka", 5.0);
    }

    static String getRandomGood() {
        int id = 1 + (int) (Math.random() * 5);
        return goods.get(id) + " " + priceOfTheGoods.get(goods.get(id));
    }
}
