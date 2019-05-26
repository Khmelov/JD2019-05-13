package by.it.akhmelev.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a=756.13;
        double x=0.3;

        double p1=cos(pow(pow(x,2)+PI/6,5));
        double p2=sqrt(x*pow(a,3));
        double p3=log(abs((a-1.12*x)/4));
        double z=p1-p2-p3;

        System.out.printf(" Z=%f",z);

    }

    private static void step2() {
    }

    private static void step3() {
    }
}
