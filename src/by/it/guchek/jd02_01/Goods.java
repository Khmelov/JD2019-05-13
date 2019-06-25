package by.it.guchek.jd02_01;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Goods {
    static String nameGood="";

    static Map<String, Double> goods = new HashMap<>();

    static {
        goods.put("Батон", 1.12);
        goods.put("Хлеб", 1.55);
        goods.put("Колбаса", 6.00);
        goods.put("Макароны", 2.50);
        goods.put("Картошка", 2.00);
        goods.put("Молоко", 1.15);
        goods.put("Сыр", 4.25);
    }

        //Map.Entry <String, Double> entry = (Map.Entry<String, Double>) goods.entrySet().iterator();
    static String getRandGood (){
        for (int i=0; i<RandCount.randFrTo(1,7); i++){
        Iterator itGoods = goods.entrySet().iterator();
        if (itGoods.hasNext()){
            itGoods.next();
            Map.Entry <String, Double> entry = (Map.Entry<String, Double>)itGoods.next();
            String nameGood = entry.getKey()+" "+entry.getValue();
        }else break;
        }

        return nameGood;
    }

}
