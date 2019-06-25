package by.it.dnevar.jd02_01;

public class BasketPensioneer implements IUseBasket {

    String name;

    BasketPensioneer(String name){
        this.name = name;
    }

    @Override
    public void takeBasket() {
        try {
            int timeout = Rnd.fromTo(150, 300);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(name + " //некоректное завершение ожидания");;
        }
        System.out.println(name + " взял корзину");
    }

    @Override
    public void putGoodstobasket() {
        try {
            int timeout = Rnd.fromTo(150, 300);
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            System.out.println(name + " //некоректное завершение ожидания");;
        }
        System.out.println(name + " положил товары в корзину");
    }
}
