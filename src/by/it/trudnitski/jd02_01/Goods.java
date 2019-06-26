package by.it.trudnitski.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer,String> goods=new HashMap<>();
    private static Map<String,Double> cost=new HashMap<>();
    static {
        goods.put(1,"Хлеб");
        goods.put(2,"Молоко");
        goods.put(3,"Масло");
        goods.put(4,"Пиво");
        goods.put(5,"Вино");

        cost.put("Хлеб",1.20);
        cost.put("Молоко",2.50);
        cost.put("Масло",1.45);
        cost.put("Пиво",2.30);
        cost.put("Вино",7.20);

    }
    static String getRandomGood(){
        int id= Helper.randomeGet(0,4);
        return goods.get(id);
    }
    static int getRandomSomeGoods(){
        return 1+((int)Math.random()*4);
    }
    static Map<String,Double> getCost(){
        return cost;
    }
}
