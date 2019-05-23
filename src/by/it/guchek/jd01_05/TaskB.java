package by.it.guchek.jd01_05;

import java.util.Scanner;

import static java.lang.Math.*;
import static java.lang.StrictMath.pow;

public class TaskB {
    public static void main(String[] args){
        step1b ();
        //step2c();

    }


    private static void step1b() {
        double y = 0;
        for (double a = 0; a <=2 ; a=a+0.2) {
            double sum1=0;
            for (int x = 1; x <=6 ; x++) {
                sum1=(Math.pow(7,a));
                sum1=sum1+sum1;
                //System.out.println(y);
                y=sum1-cos(x);
            }

            System.out.println(y);
        }
    }
    private static void step1c() {
       //double lamda, beta;

        //for (double -6<x1; x1 < 2 ; x1=x1+0.5){
          //  double xres=x1/2;
            //if xres >
        //}



    }
}

