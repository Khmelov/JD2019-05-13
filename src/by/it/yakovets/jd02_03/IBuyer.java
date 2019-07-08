package by.it.yakovets.jd02_03;

public interface IBuyer {
    void enterToMarket();

    Good chooseGoods();

    void goToQueue();

    void goOut();
}