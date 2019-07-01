package by.it.tbabich.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Goods {

    private static Map<Integer, Product> goods = new HashMap<>();

    static {
        goods.put(1, new Product("Хлеб", 1));
        goods.put(2, new Product("Молоко", 1.4));
        goods.put(3, new Product("Соль", 0.8));
        goods.put(4, new Product("Сахар", 0.9));
        goods.put(5, new Product("Сыр", 2.5));
    }

    static int getRandomGood() {
        int id = 1 + (int) (Math.random() * 5);
        return id;
    }

    static Product getProduct(int id) {
        return goods.get(id);
    }

}
