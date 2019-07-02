package by.it.zhukova.jd02_01;

import java.util.HashMap;

public class Backet {
    private static HashMap<String, Double> backet= new HashMap<>();
    static void addToBacket (Buyer buyer, String good, Double price){
        backet.put(good, price);
    }
    static void printCheck (){

    }


}
