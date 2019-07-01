package by.it.yakovets.jd02_02;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Basket {
    private int value = 0;
    private Map<String, Integer> goods = new HashMap<>();

    public void addToBasket(Good good) {
        goods.put(good.getName(), good.getPrice());
        value += good.getPrice();

    }

    public int getValue() {
        return value;
    }

    public void printContain() {
        Set<Map.Entry<String, Integer>> goods = this.goods.entrySet();
        System.out.println("Buyer take his goods from basket:");
        for (Map.Entry<String, Integer> good : goods) {
            System.out.println(good.getKey() + " by price " + good.getValue());
        }
        System.out.println("Value of basket=" + value);

    }
}
