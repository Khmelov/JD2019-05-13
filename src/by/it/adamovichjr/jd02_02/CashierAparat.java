package by.it.adamovichjr.jd02_02;

import java.util.ArrayList;

public class CashierAparat {
    synchronized static void printCheck(Cashier cashier,ArrayList<String> courentBuyerBacket) {
        int sumOfCheck = 0;
        System.out.println(cashier.toString());
        for (int i = 0; i < courentBuyerBacket.size(); i++) {
            System.out.printf("Good № %2d - %7s Price: %3d\n",i,courentBuyerBacket.get(i),Goods.goods.get(courentBuyerBacket.get(i)));
            sumOfCheck += Goods.goods.get(courentBuyerBacket.get(i));
        }
        System.out.println("Sum of check: "+ sumOfCheck);
    }
}
