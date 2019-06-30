package by.it.trudnitski.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Goods {

    private static Map<String, Double> goods = new HashMap<>();

    static {
        goods.put("Bread", 1.50);
        goods.put("Milk", 1.80);
        goods.put("Butter", 2.30);
        goods.put("Beer", 2.50);
        goods.put("Vine", 7.10);
        goods.put("Meat", 12.25);
        goods.put("Vegetables", 5.60);

    }

    static String getRandomGood() {
        List<String> keys = new ArrayList<>(goods.keySet());
        String key = keys.get(Helper.randomeGet(1, keys.size() - 1));
        Double value = goods.get(key);
        return key + " with price " + value;
    }

}
