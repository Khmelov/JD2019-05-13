package by.it.dilkevich.jd02_02;

import java.util.HashMap;
import java.util.Map;

public class Backet {

    private Map<String, Double> goodsInBacket = new HashMap<>();

     void addGoodToBacket(String name, Double value){

        goodsInBacket.put(name,value);
    }

    public Map<String, Double> getGoodsInBacket() {
        return goodsInBacket;
    }
}
