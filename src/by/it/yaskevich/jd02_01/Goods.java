package by.it.yaskevich.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods {
    private static Map<Integer, String> goods = new HashMap<>();

    static {
        goods.put(1, "a");
        goods.put(2, "b");
        goods.put(3, "c");
        goods.put(4, "d");
        goods.put(5, "e");
    }

    static String getRandomGood() {
        int id = (int)(Math.random() * 5 + 1);
        return goods.get(id);
    }
}
