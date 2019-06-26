package by.it.yakovets.jd02_01;

import java.util.*;

public class Goods {
    private static Map<String, Integer> goods = new HashMap<>();


    static {
        goods.put("Хлеб",11);
        goods.put("Молоко",22);
        goods.put("Сахар",33);
        goods.put("Соль",44);
        goods.put("Водка",55);
    }


    static String getRandom(){
        Random random    = new Random();
        List<String> keys      = new ArrayList<String>(goods.keySet());
        String key = keys.get( random.nextInt(keys.size()) );
        int price     = goods.get(key);
        return key+" by price: "+price;

    }

}
