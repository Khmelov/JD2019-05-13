package by.it.akhmelev.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Goods {

    private static Map<Integer,String> goods=new HashMap<>();

    static {
        goods.put(1,"Bread");
        goods.put(2,"Milk");
        goods.put(3,"Sugar");
        goods.put(4,"Salt");
        goods.put(5,"Vodka");
    }

    static String getRandomGood(){
        int id=1+(int)(Math.random()*5);
        return goods.get(id);
    }

}