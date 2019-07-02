package by.it.livanovich.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Backet {

    private List<Good> list = new ArrayList<>();

    void putBacket(Good good) {
        list.add(good);
    }

    Good extractBasket() {
        if (list.isEmpty())
            return null;
        else
            return list.remove(0);
    }
}
