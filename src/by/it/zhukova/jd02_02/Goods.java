package by.it.zhukova.jd02_02;

import java.util.HashMap;

public class Goods {
    private static HashMap <Integer, String> goods = new HashMap<>();
    private static HashMap <String, Double> price = new HashMap<>();

    static {
        goods.put(1,"bread");
        price.put("bread",1.20);
        goods.put(2,"milk");
        price.put("milk",1.40);
        goods.put(3,"sugar");
        price.put("sugar",1.50);
        goods.put(4,"chicken");
        price.put("chicken",3.50);
        goods.put(5,"vodka");
        price.put("vodka",7.50);
    }
    static String getRandomGood(){
        int id=1+(int)(Math.random()*5);
        return goods.get(id);
    }
    static Double getPrice(String good) {
        return price.get(good);
    }
}
