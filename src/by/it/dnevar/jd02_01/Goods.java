package by.it.dnevar.jd02_01;

import java.util.*;

public class Goods {

    private static HashMap<String,Double> goods = new HashMap<>();

    static {
        goods.put("Milk",1.4);
        goods.put("Bread",1.8);
        goods.put("Apple",3.2);
        goods.put("Meat",21.3);
        goods.put("Tomato",4.0);
        goods.put("Cucumber",2.7);
        goods.put("Mineral water",0.9);
        goods.put("Peache",7.5);
        goods.put("Chocolate",1.8);
        goods.put("Juice",2.6);
    }

    private static List<String> goodsSet = new ArrayList<>(goods.keySet());

    static String getRandomGood(){
        int id = 1+(int)(Math.random()*(goodsSet.size()-1));
        return goodsSet.get(id);
    }

    static Double getGoodPrice(String name){
        return goods.get(name);
    }
}
