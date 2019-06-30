package by.it.izaykoff.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer, Good> goods = new HashMap<>();

    static {
        goods.put(1, new Good("Bread", 2.0));
        goods.put(2, new Good("Milk", 2.5));
        goods.put(3, new Good("Sugar", 4.2));
        goods.put(4, new Good("Sold", 1.5));
        goods.put(5, new Good("Vodka", 9.0));
        goods.put(6, new Good("Beer", 6.2));
        goods.put(7, new Good("Ice-cream", 3.3));
        goods.put(8, new Good("Tomato", 7.4));
        goods.put(9, new Good("Fish", 8.5));
        goods.put(10, new Good("Apple", 2.7));
    }

    static Good getRandomGood() {
        int id = 1 + (int) (Math.random() * 10);
        return goods.get(id);
    }

}
