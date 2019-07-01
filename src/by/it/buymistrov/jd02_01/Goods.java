package by.it.buymistrov.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Goods {


    private static Map<Integer, String> goods = new HashMap<>();
    private static Map<String, Integer> goodsPrice = new HashMap<>();


    static {
        goods.put(1, "Hleb");
        goods.put(2, "Moloko");
        goods.put(3, "Sahar");
        goods.put(4, "Sol");
        goods.put(5, "Vodka");

        goodsPrice.put("Hleb", 3);
        goodsPrice.put("Moloko", 2);
        goodsPrice.put("Sahar", 5);
        goodsPrice.put("Sol", 2);
        goodsPrice.put("Vodka", 10);

    }





    static String getRandomGood(){
        int id =1+(int)( Math.random()*5);
        return goods.get(id);
    }

    static Integer getPrice(String good){
        return goodsPrice.get(good);
    }
}
