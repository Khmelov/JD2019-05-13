package by.it.izaykoff.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        stem1();
        step2();
    }

    private static void stem1() {
        for (double a = 0; a <= 2 ; a += 0.2) {
            double y = 0;
            for (int x = 1; x <= 6; x++) {
                y += pow(7,a) - cos(x);
            }
            System.out.printf("при a = %6.2f y = %g \n",a,y);

        }
    }

    private static void step2() {
        double a = 0;
        for (double x = -5.5; x < 2; x += 0.5) {
            if (x/2>-2 && x/2<=1){
                a = log10(abs(sin(pow(x,2)) + 2.74));
            }
            if (x/2>-1 && x/2<0.2 ){
                a = log10(abs(cos(pow(x,2)) + 2.74));
            }
            if (x/2 == 0.2 ){
                a = log10(abs(1/tan(pow(x,2)) + 2.74));
            }
            System.out.printf("при x/2 = %6.2f a = %g \n",x,a);

        }
    }

}
