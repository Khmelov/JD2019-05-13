package by.it.aadamovich.jd02_03;

import java.util.HashMap;

class Goods {

    private static HashMap<Integer, Good> goodsWithPrice = new HashMap<>();

    static {
        goodsWithPrice.put(1, new Good("Bread", 2.6));
        goodsWithPrice.put(2, new Good("Milk", 3.5));
        goodsWithPrice.put(3, new Good("Juice", 4.8));
        goodsWithPrice.put(4, new Good("Meat", 19.9));
        goodsWithPrice.put(5, new Good("Apple", 1.7));
    }

    static Good getRandomGood() {
        return goodsWithPrice.get(Util.getRandom(1,5));
    }

    private static double marketProfit = 0;

    // adds current cheque to total market profit and than returns increased total profit
    synchronized static double marketProfit(double cheque) {
        marketProfit += cheque;
        return marketProfit;
    }
}
