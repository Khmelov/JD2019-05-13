package by.it.dnevar.jd02_01;

public class Basket implements IUseBasket {

    String name;

    Basket(String name){
        this.name = name;
    }

    @Override
    public void takeBasket() {
        try {
            int timeout = Rnd.fromTo(100, 200);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(name + " //некоректное завершение ожидания");;
        }
        System.out.println(name + " взял корзину");
    }

    @Override
    public void putGoodstobasket() {
        try {
            int timeout = Rnd.fromTo(100, 200);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(name + " //некоректное завершение ожидания");;
        }
        System.out.println(name + " положил товары в корзину");
    }
}
