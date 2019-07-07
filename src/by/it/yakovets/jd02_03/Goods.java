package by.it.yakovets.jd02_03;

import java.util.*;

public class Goods {
    private static Map<String, Integer> goods = new HashMap<>();


    static {
        goods.put("Хлеб", 11);
        goods.put("Молоко", 22);
        goods.put("Сахар", 33);
        goods.put("Соль", 44);
        goods.put("Водка", 55);
    }


    static Good getRandom() {
        Random random = new Random();
        List<String> keys = new ArrayList<>(goods.keySet());
        String key = keys.get(random.nextInt(keys.size()));
        Integer price = goods.get(key);
        Good choosedGood = new Good(key, price);
        System.out.println(key + " by price: " + price);
        return (choosedGood);

    }

}