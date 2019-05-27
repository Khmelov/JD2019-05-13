package by.it.guchek.jd01_05;
import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args){
        Step1();
        Step2();
        Step3();


    }

    private static void Step1() {
        double a=756.13;
        double x=0.3;
        double z=cos(pow((x*x+PI/6),5));
        z=z-sqrt(x*pow(a,3));
        z=z-log(abs((a-1.12*x)/4));
        System.out.println("z="+z);
        z=cos(pow((x*x+PI/6),5))-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4));
        System.out.println("z="+z);
    }

    private static void Step2() {
        double y;
        double a=1.21;
        double b=0.371;
        y=tan(pow(a+b,2));
        y=y-cbrt(a+1.5)+a*pow(b,5)-b/log(a*a);
        System.out.println("y="+y);
    }

    private static void Step3() {
        double x=12.1;
        double a;
        double e,f;
        for ( a = -5; a <=12 ; a=(a+3.75)) {
            f = exp(a * x) - 3.45 * a;  //e -экспонента
            System.out.printf("При а=%6.2f f=%g\n",a,f);
        }
    }

}
