package by.it.maniuk.jd02_03;

import java.util.HashMap;
import java.util.Map;

class Goods {

    private static Map<Integer,String> goods=new HashMap<>();
    private static Map<String,Double> cost = new HashMap<>();

    static {
        goods.put(1,"Хлеб");
        goods.put(2,"Молоко");
        goods.put(3,"Сахар");
        goods.put(4,"Соль");
        goods.put(5,"Водка");

        cost.put("Хлеб", 2.5);
        cost.put("Молоко", 3.1);
        cost.put("Сахар", 1.2);
        cost.put("Соль", 1.5);
        cost.put("Водка", 6.5);
    }


    static String getRandomGood(){
        int id=1+(int)(Math.random()*5);
        return goods.get(id);
    }
    static int getRandomQuantityOfGoods(){
        return 1+(int)(Math.random()*4);
    }

    static Map<String, Double> getCost() {
        return cost;
    }
}
