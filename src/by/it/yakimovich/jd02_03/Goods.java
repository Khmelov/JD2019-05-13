package by.it.yakimovich.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Goods {

    private static Map<Integer,String> goods=new HashMap<>();
    private static Map<String,Integer> goodCost=new HashMap<>();

    static {
        goods.put(1,"Bread");
        goods.put(2,"Milk");
        goods.put(3,"Sugar");
        goods.put(4,"Salt");
        goods.put(5,"Vodka");


        goodCost.put("Bread",3);
        goodCost.put("Milk",2);
        goodCost.put("Sugar",6);
        goodCost.put("Salt",8);
        goodCost.put("Vodka",5);
    }

    static String getRandomGood(){
        int id=1+(int)(Math.random()*5);
        return goods.get(id);
    }

    public static Integer getPrice(String good){
        Integer price=goodCost.get(good);
        return price;
    }

}
