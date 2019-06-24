package by.it.akhmelev.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Goods {

    private static Map<Integer,String> goods=new HashMap<>();

    static {
        goods.put(1,"Хлеб");
        goods.put(2,"Молоко");
        goods.put(3,"Сахар");
        goods.put(4,"Соль");
        goods.put(5,"Водка");
    }

    static String getRandomGood(){
        int id=1+(int)(Math.random()*5);
        return goods.get(id);
    }

}
