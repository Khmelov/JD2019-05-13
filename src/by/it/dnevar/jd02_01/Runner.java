package by.it.dnevar.jd02_01;

import java.util.ArrayList;
import java.util.List;

public class Runner {

    static int countBuyers = 0;

/*TODO Общее число покупателей в магазине плавно изменялось - около 10 в начале каждой минуты и
от 30 до 40 в середине каждой минуты (т.е. первые 30 секунд в минуте добавляйте каждую
секунду от 0 до 2 покупателей так, чтобы всего их было N>=t+10, а вторые 30 секунд впускайте
новых только если N<=40+(30-t). t – это текущая секунда. Всего вход открыт две минуты.*/

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
