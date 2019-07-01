package by.it.aadamovich.jd02_03;

import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

class Basket {

    static final int BASKETS_LIMIT = 50;
    private static final BlockingDeque<Basket> basketsStore = new LinkedBlockingDeque<>(BASKETS_LIMIT);

    static {
        for (int i = 1; i < BASKETS_LIMIT + 1; i++) {

            basketsStore.add(new Basket("Basket №" + i));
        }
    }

    static Basket takeBasket() throws InterruptedException {
        return basketsStore.takeLast();
    }

    static void returnBasket(Basket basket) {
        basketsStore.addLast(basket);
    }


    private String name;

    private Deque<Good> basket = new LinkedList<>();

    private Basket() {
    }

    private Basket(String name) {
        this.name = name;
    }

    Good getGoodFromBasket() {
        return basket.pollLast();
    }

    void putGoodToBasket(Good good) {
        basket.addLast(good);
    }

    void emptyBasket() {
        basket.clear();
    }

    int basketContentSize() {
        return basket.size();
    }

    @Override
    public String toString() {
        return name;
    }
}
