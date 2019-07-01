package by.it.orlov.jd02_02;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Goods {

    private static HashMap<String, Integer> goodsWithPrice = new HashMap<>();

    static {
        goodsWithPrice.put("Хлеб", 3);
        goodsWithPrice.put("Мясо", 5);
        goodsWithPrice.put("Водка", 30);
        goodsWithPrice.put("Сок", 35);
        goodsWithPrice.put("Банан", 13);
    }

    private static List<String> goods = new ArrayList<>(goodsWithPrice.keySet());

    static String getRandomGood() {
        return goods.get(Util.getRandom(goods.size() - 1));
    }

    static int getPrice(String goods) {
        return goodsWithPrice.get(goods);
    }

    private static int marketProfit = 0;

    // adds current cheque to total market profit and than returns increased total profit
    synchronized static int increaseProfit(int cheque) {
        marketProfit += cheque;
        return marketProfit;
    }
}
