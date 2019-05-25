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

            i++;


        }
        for (int i1 = 0; i1 < array.length; i1++) {
            double ar = array[i1];
            if ((i1+1) %5 == 1) System.out.println();
            if (i<=9)
            System.out.format("M[%3d] =  %-1.5f ", i1, ar);
            else System.out.format("M[%3d] =  %-1.5f ", i1, ar);

        }
    }
        private static void step2(){
            System.out.println(" ");
            System.out.println("Massiv B: >3.5");
        int counter =0;
        int i=0;

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
            double e =1;
            for (double v : newArray) {
                e *= v;

            }
            //double midle = pow(e,1/newArray.length-1);
            double midle =  Math.exp(Math.log(e)/newArray.length-1);

            for (int i1 = 0; i1 < newArray.length; i1++) {
                double ar = newArray[i1];
                if ((i1+1) %5 == 1) System.out.println();
                if (i<=9)
                    System.out.format("M[% -2d] =  %-1.1f ", i1, ar);
                else System.out.format("M[%2d] =  %-1.1f ", i1, ar);
            }
            System.out.format("%10s %-2.2f ", "Middle" ,midle);


            }
    }

