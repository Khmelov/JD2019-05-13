package by.it.guchek.jd02_02;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class Bucket1 {

    private List<Good> goodList = new ArrayList<>();

    void  add (Good good) {
        goodList.add(good);
    }

    void readGood(String nameBuyer) {
        Iterator it = goodList.iterator();
        while (it.hasNext()){
            System.out.println(nameBuyer+" ------ "+it.next().toString());
        }
    }

    Good getOutOfBucket() {
        if (goodList.isEmpty())
            return  null;
        else
            return goodList.remove(0);


    }
}
