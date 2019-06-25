package by.it.aadamovich.jd02_01;

import java.util.Random;

class Util {

    private static Random random = new Random();

    static int getRandom(int from, int to) {
        return random.nextInt(to - from + 1) + from;
    }

    static void sleep(int timeout, int speed) {
        try {
            Thread.sleep(timeout * speed / 100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
//    private static HashMap<String, Integer> goods = new HashMap<>();
//    private Set<Map.Entry<String, Integer>> set = goods.entrySet();
//
//    static {
//        goods.put("Bread", 5);
//        goods.put("Milk", 7);
//        goods.put("Juice", 10);
//        goods.put("Meat", 25);
//        goods.put("Apple", 3);
//    }

    static String getRandomGood() {
        int random = getRandom(1, 5);

        switch (random) {
            case 1:
                return "Bread";
            case 2:
                return "Milk";
            case 3:
                return "Juice";
            case 4:
                return "Meat";
            case 5:
                return "Apple";
        }
        return "Basket";
    }
}
