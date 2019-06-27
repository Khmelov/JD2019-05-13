package by.it.livanovich.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Basket {
    public static Map<String, Double> goodWithValue = new HashMap<>();

    static {
        goodWithValue.put("Хлеб", 0.69);
        goodWithValue.put("Молоко", 1.20);
        goodWithValue.put("Сахар", 1.17);
        goodWithValue.put("Соль", 0.55);
        goodWithValue.put("Творог", 1.69);
    }

    static Map<String, Double> basket = new HashMap<>();

    static void putInBasket(String good) {
        basket.put(good, goodWithValue.get(good));
    }

    public static void Basket(String name) {
        System.out.printf("В корзине " + name + ":");
        for (Map.Entry<String, Double> entry : basket.entrySet()) {
            System.out.printf("%10s за %2.2f рублей; ", entry.getKey(), entry.getValue());
        }
        System.out.println();
    }
}
