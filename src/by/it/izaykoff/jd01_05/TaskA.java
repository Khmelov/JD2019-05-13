package by.it.izaykoff.jd01_05;

import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        step1();
        step2();
        step3();
    }

    private static void step1() {
        double a = 756.13;
        double x = 0.3;
        double z = cos(pow((pow(x,2)+PI/6),5)) - sqrt(pow(x*a,3)) - log(abs((a-1.12*x)/a));
        System.out.println("z= " + z);
    }
    private static void step2() {
        double a = 1.21;
        double b = 0.371;
        double y = tan(pow(a+b,2)) - cbrt(a+1.5) + pow(a*b,5) - (b/log(pow(a,2)));
        System.out.println(y);
    }
    private static void step3() {


    }
}
