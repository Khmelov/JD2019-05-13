package by.it.aadamovich.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Basket {

    static final int BASKETS_LIMIT = 50;
    private static final BlockingDeque<Basket> baskets = new LinkedBlockingDeque<>(BASKETS_LIMIT);

    static {
        for (int i = 1; i < BASKETS_LIMIT + 1; i++) {

            baskets.add(new Basket("Basket №" + i));
        }
    }

    static Basket takeBasket() {
        return baskets.pollLast();
    }

    static void returnBasket(Basket basket) {
        baskets.addLast(basket);
    }

    private String name;

    private Deque<Good> basketContent = new LinkedList<>();

    Basket() {
    }

    private Basket(String name) {
        this.name = name;
    }

    Good getGoodFromBasket() {
        return basketContent.pollLast();
    }

    void putGoodToBasket(Good good) {
        basketContent.addLast(good);
    }

    void emptyBasket() {
        basketContent.clear();
    }

    int basketContentSize() {
        return basketContent.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
