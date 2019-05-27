package by.it.lasotskaya.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }
    private  static void step1(){
        double a=756.13;
        double x=0.3;
        double p1=cos(pow(pow(x,2) +PI/6,5));
        double p2 =sqrt(x*pow(a,3));
        double p3 =log(abs((a-1.12*x)/4));
        double res = p1 - p2 - p3;
        System.out.println("Result is " + res);
    }
    private  static  void step2(){
        double a=1.21;
        double b=0.371;
        double p1 =tan(pow((a+b),2));
        double p2 =a*pow(b,5 );
        double p3 = b/log(a*a);
        double p4 = pow((a+1.5),1/3.0);
        double res = p1 - p4 + p2 -p3;
        System.out.println("Result is " + res);
    }
    private  static  void step3(){
        double x =12.1;
        for ( double a=-5; a<=12;a=a+3.75 ){
            double f = exp(a*x)-3.45*a;
            System.out.printf("При a=%6.2f F=%g\n",a,f);
        }
    }

}
