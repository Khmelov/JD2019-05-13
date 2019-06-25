package by.it.dnevar.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    static int countBuyers = 0;


    public static void main(String[] args) throws InterruptedException {

        List<IBuyer> buyersList = new ArrayList<>();
        for(int time = 0; time<120;time++){
            Thread.sleep(1000);
            int count = Rnd.fromTo(0,2);
            for (int i = 0; i < count; i++) {
                countBuyers++;
                if(countBuyers%Rnd.fromTo(4,5)!=0) {
                    Buyer buyer = new Buyer(countBuyers);
                    buyer.start();
                    buyersList.add(buyer);
                }else{
                    BuyerPensioneer buyerP = new BuyerPensioneer(countBuyers);
                    buyerP.start();
                    buyersList.add(buyerP);
                }
            }
        }
    }
}
