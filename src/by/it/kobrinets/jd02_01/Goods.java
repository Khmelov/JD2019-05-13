package by.it.kobrinets.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer, String> goods = new HashMap<>();
    private static Map<String, Double> priceOfTheGoods = new HashMap<>();

    static {
        goods.put(1, "Bread");
        priceOfTheGoods.put("Bread", 1.8);
        goods.put(2, "Milk");
        priceOfTheGoods.put("Milk", 2.0);
        goods.put(3, "Sold");
        priceOfTheGoods.put("Sold", 3.2);
        goods.put(4, "Vegetables");
        priceOfTheGoods.put("Vegetables", 4.7);
        goods.put(5, "Meat");
        priceOfTheGoods.put("Meat", 10.2);
    }

    static String getRandomGood() {
        int id = 1 + (int) (Math.random() * 5);
        return goods.get(id) + " " + priceOfTheGoods.get(goods.get(id));
    }
}