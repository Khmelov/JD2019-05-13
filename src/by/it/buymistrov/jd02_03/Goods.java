package by.it.buymistrov.jd02_03;


import java.util.HashMap;
import java.util.Map;

class Goods {

    private static Map<Integer,String> goods=new HashMap<>();
    private static Map<String, Integer> goodsPrice = new HashMap<>();

    static {
        goods.put(1,"Bread");
        goods.put(2,"Milk");
        goods.put(3,"Sugar");
        goods.put(4,"Salt");
        goods.put(5,"Vodka");

        goodsPrice.put("Bread", 1);
        goodsPrice.put("Milk", 2);
        goodsPrice.put("Sugar", 3);
        goodsPrice.put("Salt", 4);
        goodsPrice.put("Vodka", 5);
    }

    static String getRandomGood(){
        int id=1+(int)(Math.random()*5);
        return goods.get(id);
    }

    static Integer getPrice(String good){
        return goodsPrice.get(good);
    }

}

