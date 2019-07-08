package by.it.dilkevich.jd02_03;

import java.util.HashMap;
import java.util.Map;

public class Backet {

    private Map<String, Double> goodsInBacket = new HashMap<>();

    double sumGoodsCost=0;
     void addGoodToBacket(String name, Double value){

         if(goodsInBacket.containsKey(name)){
             goodsInBacket.put(name,value*2);
         }
         else
             goodsInBacket.put(name,value);

         sumGoodsCost+=value;
    }

    public Map<String, Double> getGoodsInBacket() {
        return goodsInBacket;
    }
}
