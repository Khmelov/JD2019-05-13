package by.it.maniuk.jd02_01;

public class Market {
    public static void main(String[] args) {
        int countBuyer=0;
        for (int time = 0; time <120 ; time++) {
           int count = Util.rnd(2);
            for (int i = 0; i <count ; i++) {
                Buyer buyer = new Buyer(++countBuyer);
                buyer.start();
            }
            Util.sleep(1000);
        }

    }
}
