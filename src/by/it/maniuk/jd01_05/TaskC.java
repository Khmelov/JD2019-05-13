package by.it.maniuk.jd01_05;

import static java.lang.Math.*;

public class TaskC {
    private static double[] array = new double[37];
    public static void main(String[] args) {
        step1();
        step2();
    }

    private static void step1() {
        double z;
        int i = 0;


        for (double x = 5.33; x <= 9; x = x + 0.1) {
            z = cbrt(((x * x) + 4.5));

            array[i] = z;
            System.out.println(array[i]);
            i++;


        }
        for (double ar : array) {
            System.out.format("%-6.4f ", ar);
        }
    }
        private static void step2(){
            System.out.println(" ");
            System.out.println("Massiv B:");
        int counter =0;
        int i=0;
            double e= 0;
        for (int j = 0; j <array.length ; j++) {

            if (array[i] > 3.5){

                counter ++;
            }
            i++;

        }
        i=0;
        double[] newArray = new double[counter];
            for (double value : array) {

                if (value > 3.5) {

                    newArray[i] = value;
                    i++;
                }

            }
            for (double v : newArray) {
                e *= v;
            }
            double midle = pow(e,newArray.length-1);

        for (double ar : newArray) {
            System.out.format("%-6.4f ", ar);
        }
            System.out.format("%-10s %-2.9f ", "Massiv >3.5" ,midle);


            }
    }

