package by.it.guchek.jd02_02;

import java.util.HashMap;
import java.util.Map;

class Bucket {

    static synchronized void goodsInBacket() {

        for (int i = 0; i < RandCount.randFrTo(1, 4); i++) {

            Object newGood = Goods.getRandGood();
            System.out.printf("                 %s%n",  newGood);


        }
    }
}
