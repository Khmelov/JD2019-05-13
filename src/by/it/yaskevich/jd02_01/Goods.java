package by.it.yaskevich.jd02_01;

import java.util.HashMap;
import java.util.Map;

class Goods {
    private static Map<Integer, Good> goods = new HashMap<>();

    private static class Good {
        private String name;
        private int price;

        Good(String name, int price) {
            this.name = name;
            this.price = price;
        }

        String getName() {
            return name;
        }

        int getPrice() {
            return price;
        }
    }

    static {
        goods.put(1, new Good("Хлеб", 5));
        goods.put(2, new Good("Молоко", 7));
        goods.put(3, new Good("Сахар", 6));
        goods.put(4, new Good("Соль", 10));
        goods.put(5, new Good("Водка", 20));
    }

    static String getRandomGood(){
        Good good = goods.get(1 + (int) (Math.random() * 5));
        return good.getName() + "(" + good.getPrice() + " руб.)";
    }
}
