package by.it.livanovich.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods {
    public static Map<Integer, String> good = new HashMap<>();

    static {
        good.put(1, "Хлеб");
        good.put(2, "Молоко");
        good.put(3, "Сахар");
        good.put(4, "Соль");
        good.put(5, "Творог");
    }

    static String getRandomGood() {
        int id = Rnd.Rnd(1, 5);
        return good.get(id);
    }
}
