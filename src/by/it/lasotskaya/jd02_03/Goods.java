package by.it.lasotskaya.jd02_03;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Goods {

   private static HashMap products = new HashMap() {
       {
           this.put("Bread", 1.1);
           this.put("Milk", 2.2);
           this.put("Sugar", 3.3);
           this.put("Salt", 4.4);
           this.put("Butter", 5.5);
       }
   };
   static ArrayList<Map.Entry<String, Double>> pairs = new ArrayList<>(products.entrySet());

}