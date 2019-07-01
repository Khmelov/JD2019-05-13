package by.it.dilkevich.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Backet {

    private static Map<String, Double> goodsInBacket = new HashMap<>();

    static void addGoodToBacket(String name, Double value){

        goodsInBacket.put(name,value);
    }
}
