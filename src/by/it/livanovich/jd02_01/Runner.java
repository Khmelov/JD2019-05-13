package by.it.livanovich.jd02_01;

public class Runner {

    public static void main(String[] args) {
        int countBuyer=0;
        for (int t = 1; t <4 ; t++) {
            int count=Rnd.Rnd(2);
            for (int i = 0; i <=count ; i++) {
                countBuyer++;
                Buyer buyer=new Buyer(countBuyer);
                buyer.start();
            }
        }
    }
}
