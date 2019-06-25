package by.it.dnevar.jd02_01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Good {

    HashMap<String, Double> goods = new HashMap<>();

    Good(){
        goods.put("Хлеб",1.5);
        goods.put("Молоко",2.0);
        goods.put("Колбаса",23.75);
        goods.put("Сметана",4.25);
        goods.put("Бананы",3.0);
        goods.put("Помидоры",3.5);
        goods.put("Персики",6.8);
        goods.put("Черешня",7.15);
        goods.put("Печенье",3.45);
        goods.put("Минералка",1.15);
        goods.put("Огурцы",2.2);
        goods.put("Сыр",15.9);
    }

    String getRandomGood(){
        List<String> keys = new ArrayList<>(goods.keySet());
        String randomKey = keys.get(Rnd.fromTo(0,keys.size()-1));
        Double value = goods.get(randomKey);
        return randomKey + " по цене " + Double.toString(value);
    }
}
