package by.it.dilkevich.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer,String> goods=new HashMap<>();
    private static Map<String,Double> goodsCost = new HashMap<>();

    static {
        goods.put(1,"Хлеб");
        goods.put(2,"Молоко");
        goods.put(3,"Сахар");
        goods.put(4,"Соль");
        goods.put(5,"Водка");

        goodsCost.put("Хлеб", 1.40);
        goodsCost.put("Молоко", 1.12);
        goodsCost.put("Сахар", 1.55);
        goodsCost.put("Соль", 0.99);
        goodsCost.put("Водка", 11.3);
    }

    static String getRandomGood(){
        int id=1+(int)(Math.random()*5);
        return goods.get(id);
    }
    static Double getCostOfGood(String product){

        return goodsCost.get(product);
    }
}
