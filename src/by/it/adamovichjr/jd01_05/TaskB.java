package by.it.adamovichjr.jd01_05;
import static java.lang.Math.*;
public class TaskB {
    private static void step1(){
        for (double a = 0; a <= 2; a = a + 0.2){
            double y = 0;
            for (int x = 1; x <7;x++){
                y += pow(7,a) - cos(x);
            }
            System.out.printf("При a =%6.2f y =%g\n", a, y);
        }
    }

    private static void step2(){
        double a = 0;
        for (double x = -5.5; x < 2; x = x + 0.5){
            if(x > -4 && x <= -2){
                a = log10(abs(sin(x*x) + 2.74));
                System.out.printf("При х =%4.1f a =%g\n",x,a);
            }
            if(x > -2 && x < 0.4){
                a = log10(abs(cos(x*x) + 2.74));
                System.out.printf("При х =%4.1f a =%g\n",x,a);
            }
            if(x == 0.4){
                a = log10(abs(1/tan(x*x) + 2.74));
                System.out.printf("При х =%4.1f a =%g\n",x,a);
            }
        }
    }

    public static void main(String[] args) {
        step1();
        step2();
    }
}
