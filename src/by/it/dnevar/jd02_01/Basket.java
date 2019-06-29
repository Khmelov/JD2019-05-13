package by.it.dnevar.jd02_01;

import java.util.HashMap;

import static by.it.dnevar.jd02_01.Buyer.time;

public class Basket implements IUseBasket {

    static HashMap<String,Double> goodsInBasket = new HashMap<>();

    @Override
    public void takeBasket() {
        try {
            int timeout = Utility.fromTo(time, 2*time);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(" //некоректное завершение ожидания");
        }
    }

    @Override
    public void putGoodsToBasket() {
        try {
            int timeout = Utility.fromTo(time, 2*time);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(" //некоректное завершение ожидания");;
        }
    }
}
