package by.it.adamovichjr.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class Goods {
    private static Random random = new Random();
    final static HashMap<String,Integer>goods = new HashMap<>();

    static {
        goods.put("Bread",2);
        goods.put("Water",1);
        goods.put("Beer",3);
        goods.put("Cookies",5);
        goods.put("TV",20);
    }
    static String getGood(){
        ArrayList<String>keysOfGoods = new ArrayList<>(goods.keySet());
        return keysOfGoods.get(random.nextInt(keysOfGoods.size()));
    }
}

