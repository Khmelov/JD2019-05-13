package by.it.yakovets.jd02_02;

import java.util.Map;

public interface IBuyer {
    void enterToMarket();

    Good chooseGoods();

    void goToQueue();

    void goOut();
}