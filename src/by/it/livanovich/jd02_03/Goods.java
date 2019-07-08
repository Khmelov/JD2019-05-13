package by.it.livanovich.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Goods {
    public static Map<Integer, Good> good = new HashMap<>();

    static {
        good.put(1, new Good("Хлеб",0.69));
        good.put(2, new Good("Молоко", 1.20));
        good.put(3, new Good("Сахар", 1.37));
        good.put(4, new Good("Соль",0.55));
        good.put(5, new Good("Творог", 2.09));
    }

    static Good getRandomGood() {
        int id = Rnd.Rnd(1, 5);
        return good.get(id);
    }
}
