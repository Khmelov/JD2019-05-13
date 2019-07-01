package by.it.akhmelev.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Goods {

    private static Map<Integer, Good> goods=new HashMap<>();

    static {
        goods.put(1,new Good("Bread",2.2));
        goods.put(2,new Good("Milk",3.3));
        goods.put(3,new Good("Sugar",4.4));
        goods.put(4,new Good("Salt",1.1));
        goods.put(5,new Good("Vodka",9.9));
    }

    static Good getRandomGood(){
        int id=1+(int)(Math.random()*5);
        return goods.get(id);
    }

}
