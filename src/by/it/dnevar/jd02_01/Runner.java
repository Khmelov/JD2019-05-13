package by.it.dnevar.jd02_01;

import java.util.LinkedList;
import java.util.List;

public class Runner {

    public static int countBuyers = 0;
    public static List<IBuyer> buyersList = new LinkedList<>();

/*TODO Общее число покупателей в магазине плавно изменялось - около 10 в начале каждой минуты и
от 30 до 40 в середине каждой минуты (т.е. первые 30 секунд в минуте добавляйте каждую
секунду от 0 до 2 покупателей так, чтобы всего их было N>=t+10, а вторые 30 секунд впускайте
новых только если N<=40+(30-t). t – это текущая секунда. Всего вход открыт две минуты.*/

    public static void main(String[] args) throws InterruptedException {

        for(int time = 0; time<120;time++){
            Thread.sleep(1000);
            int count = 0;
            count = Rnd.fromTo(0,2);
            for (int i = 0; i < count; i++) {
                if(countBuyers%Rnd.fromTo(4,5)!=0) {
                    countBuyers++;
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
