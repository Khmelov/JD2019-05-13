package by.it.trudnitski.jd01_05;
import static java.lang.Math.*;

public class TaskB {
    public static void main(String[] args) {
        step1();
        step2();
    }
    private static void step1() {
        double y=0;
        double res=0;
        for (double a = 0; a<=2 ; a=a+0.2) {
            for (double x = 1; x <= 6; x++) {
                res += pow(7, a) - cos(x);
            }
            y = y + res;
            System.out.printf("При a=%6.2f y=%g\n",a,y);
        }
        System.out.println();
    }

    private static void step2() {
        double a;
        double b=0;
        for (double x =-5.5; x<2 ; x=x+0.5) {

            if(-2<x/2&&x/2<=-1){
                b=sin(x*x);
            }
            else if(-1<x/2&&x/2<0.2){
                b=cos(x*x);
            } else if(x/2==0.2){
                b=tan(x*x);
            } else continue;

            a=log10(abs(b+2.74));
            System.out.printf("При x/2=%6.2f a=%g\n",x/2,a);
        }
    }
}
