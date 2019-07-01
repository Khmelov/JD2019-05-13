package by.it.tbabich.jd02_03;

import java.util.ArrayList;
import java.util.List;

class Backet {

    private List<Product> backet = new ArrayList<>();

    public void putToBacket(Product product){
        backet.add(product);
    }

    public List<Product> getProductList() {
        return backet;
    }
}
