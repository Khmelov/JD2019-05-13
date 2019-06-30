package by.it.trudnitski.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static final Map<Integer, Good> goods = new HashMap<>();

    static {
        goods.put(1, new Good("Bread", 1.50));
        goods.put(2, new Good("Milk", 1.80));
        goods.put(3, new Good("Butter", 2.30));
        goods.put(4, new Good("Beer", 2.50));
        goods.put(5, new Good("Vine", 7.10));
        goods.put(6, new Good("Meat", 12.25));
        goods.put(7, new Good("Vegetables", 5.60));

    }

    static Good getRandomGood() {

        return goods.get(1 + (int) (Math.random() * 7));
    }


}
