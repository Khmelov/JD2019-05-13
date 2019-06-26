package by.it.tbabich.jd02_01;

import java.util.HashMap;
import java.util.Map;

public class Backet {

    private static Map<Integer, Integer> backet = new HashMap<>();

    public void putToBacket(Integer good, int cost){
        backet.put(good, cost);
    }

}
