package by.it.maniuk.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Backet {
    private List<String> goods = new ArrayList<>();

    public void putGoodsToBacket() {
        for (int i = 0; i < Goods.getRandomQuantityOfGoods(); i++) {
            putGoodsToBacket();
            String good = Goods.getRandomGood();
            System.out.println(this + " choose " + good);
            goods.add(good);
        }
        StringBuilder sb = new StringBuilder();
        for (String good : goods) {
            sb.append(good).append(" ").append(Goods.getCost().get(good)).append("  ");
        }
        Double cost = 0d;
        for (String good : goods) {
            cost += Goods.getCost().get(good);
        }
        cost = Math.floor(cost * 100) / 100;
        sb.append("summa = ").append(cost);
    }
}
