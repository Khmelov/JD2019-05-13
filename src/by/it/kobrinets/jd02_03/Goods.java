package by.it.kobrinets.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Goods {

    private static HashMap<String, Double> products = new HashMap<String, Double>() {
        {
            this.put("Water", 1.3);
            this.put("Milk", 2.1);
            this.put("Bread", 2.5);
            this.put("Chicken", 4.7);
            this.put("Meat", 6.2);
        }
    };

    static ArrayList<Map.Entry<String, Double>> pairs = new ArrayList<>(products.entrySet());
}