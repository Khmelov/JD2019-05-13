package by.it.gavrilovec.jd01_05;
import static java.lang.Math.*;
public class TaskA {

    private static double step1(double x){
        return cos(pow((pow(x,2)+PI/6),5));
    }

    private static double step2(double a,double x){
        return sqrt(x*pow(a,3));

    }

    private static double step3(double a,double x){
        return log(abs((a-1.12*x)/4));
    }

    public static void main(String[] args) {
        double a=756.13;
        double x=0.3;
        double z=cos(pow((pow(x,2)+PI/6),5))-sqrt(x*pow(a,3))-log(abs((a-1.12*x)/4));
        System.out.println(z);
        z=step1(x)-step2(a,x)-step3(a,x);
        System.out.println(z);
        a=1.21;
        double b=0.371;
        double  y=tan(pow((a+b),2))-cbrt(a+1.5)+a*pow(b,5)-b/log(pow(a,2));
        System.out.println(y);
        x=12.1;
        for (a= -5; a <=12 ;  a+=3.75 ) {
            double f=pow(E,a*x)-3.45*a;
            System.out.printf("a=%f\tf=%f\n",a,f);
           }
    }
}
