package by.it.aadamovich.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Goods {

    private static HashMap<String, Integer> goodsWithPrice = new HashMap<>();

    static {
        goodsWithPrice.put("Bread", 5);
        goodsWithPrice.put("Milk", 7);
        goodsWithPrice.put("Juice", 10);
        goodsWithPrice.put("Meat", 25);
        goodsWithPrice.put("Apple", 3);
    }

    private static List<String> goods = new ArrayList<>(goodsWithPrice.keySet());

    static String getRandomGood() {
        return goods.get(Util.getRandom(0, goods.size() - 1));
    }

}
