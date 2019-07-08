package by.it.orlov.jd02_03;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Basket {
    private static List<Good> list = new ArrayList<>();

    static void add(Good good) {
        list.add(good);
    }

    static String readGood(String nameBuyer) {
        String res = "";
        Iterator iter = list.iterator();
        while (iter.hasNext()) {
            res+=iter.next().toString();
        }
        return res;
    }
}
