package by.it.tbabich.jd02_01;

import java.util.ArrayList;
import java.util.List;

class Backet {

    private static List<Product> backet = new ArrayList<>();

    public void putToBacket(Product product){
        backet.add(product);
    }

}
