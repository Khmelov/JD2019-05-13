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

    void readGoodForBill(String nameBuyer) {

        Iterator itTwo = goodList.iterator();
        while (itTwo.hasNext()){
            System.out.println(itTwo.next().toString());
            System.out.println("-----------------------");
        }
    }

    int goodListsize(){
        return goodList.size();
    }

    Good getOutOfBucket() {
        if (goodList.isEmpty())
            return  null;
        else
            return goodList.remove(0);


    }
}
