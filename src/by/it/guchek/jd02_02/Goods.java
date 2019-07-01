package by.it.guchek.jd02_02;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

class Goods {
    //static String nameGood="";

    private static Map<Integer, Good> goods = new HashMap<>();

    static {
        goods.put(1, new Good("Батон", 1.12));
        goods.put(2,new Good("Хлеб", 1.55));
        goods.put(3, new Good("Колбаса", 6.00));
        goods.put(4, new Good("Макароны", 2.50));
        goods.put(5,new Good("Картошка", 2.00));
        goods.put(6, new Good("Молоко", 1.15));
        goods.put(7, new Good("Сыр", 4.25));
    }

        //Map.Entry <String, Double> entry = (Map.Entry<String, Double>) goods.entrySet().iterator();
    static synchronized Good getRandGood (){
        int id=0;
        for (int i = 0; i<(RandCount.randFrTo(1,4)); i++){
            id=1+(int)(Math.random()*(goods.size()));
        }
        return goods.get(id);
        //if (itGoods.hasNext()){
        /*Iterator itGoods = goods.entrySet().iterator();
        for (int i = 0; i<(RandCount.randFrTo(1,goods.size())); i++){
        if (itGoods.hasNext()){

            Map.Entry <String, Double> entry = (Map.Entry<String, Double>) itGoods.next();
            nameGood = entry.getKey()+" цена "+entry.getValue()+"р.";

         }else break;
        }*/
    }

}
