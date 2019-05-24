package by.it.guchek.jd01_05;

import java.util.Scanner;

import static java.lang.Math.*;
import static java.lang.StrictMath.pow;

public class TaskB {
    public static void main(String[] args){
        step1b ();
        step1c();

    }


    private static void step1b() {
        double y = 0;
        for (double a = 0; a <=2 ; a=a+0.2) {
            double sum1;
            for (int x = 1; x <=6 ; x++) {
                sum1=(Math.pow(7,a)-cos(x));
                y=sum1+y;
            }

            System.out.printf("%10.20f\n",y);
        }
    }
    private static void step1c() {

        double lamda, beta, xres;

        for (double x=-5.5; x < 2 ; x+=0.5){
          xres=x/2;
        if (xres/2>-2 && xres <=-1)
            beta= sin(x*x);
        else  if (xres>-1 && xres<0.2)
                beta= cos(x*x);
        else  if (xres==0.2)
                beta=1/tan(x*x);
        else continue;

            lamda=log10(abs(beta+2.74));
            System.out.printf("%s%-1.2f%8s%5.10f\n", "Если x/2= ", xres, "Лямда= ",lamda);
        }

    }
}

