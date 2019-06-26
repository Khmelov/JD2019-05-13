package by.it.livanovich.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    public static void main(String[] args) {
        List<Buyer> buyerList=new ArrayList<>();
        int countBuyer=0;
        int now=0;
        for (int t = 1; t <120 ; t++) {
            if (t<30 || (t<90 && t>60)) {
                int count = Rnd.Rnd(2);
                for (int i = 0; i <= count; i++) {
                    countBuyer++; now+=i;
                    Buyer buyer = new Buyer(countBuyer);
                    buyer.start();
                    buyerList.add(buyer);
                }
            }
            else {
                int count = Rnd.Rnd(2);
                for (int i = 0; i <= count; i++) {
                    countBuyer++; now+=i;
                    Buyer buyer = new Buyer(countBuyer);
                    if (now>40+(30-t)){
                    buyer.start();
                    buyerList.add(buyer);}
                    else Thread.yield();
                }
            }

        }
    }
}
