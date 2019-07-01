package by.it.yaskevich.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Goods {
    private static final Map<Integer, Good> goods = new HashMap<>();

    static {
        goods.put(1, new Good("Хлеб", 5));
        goods.put(2, new Good("Молоко", 7));
        goods.put(3, new Good("Сахар", 6));
        goods.put(4, new Good("Соль", 10));
        goods.put(5, new Good("Водка", 20));
        goods.put(6, new Good("Конфеты", 8));
        goods.put(7, new Good("Мороженое", 2));
    }

    static Good getRandomGood(){
        return goods.get(1 + (int)(Math.random() * 7));
    }
}
