package by.it.guchek.jd01_05;

import static java.lang.Math.*;

public class TaskC {

    public static void main(String[] args) {

        int min=20;
        int max=40;

        double [] arrayZ = new double[min+(int)( random()*(max-min)+1)];
        double step=(9-5.33)/arrayZ.length;
        double x = 5.33;


        for (int i = 0; i <arrayZ.length ; i++) {
            arrayZ[i]= cbrt(pow(x,2)+4.5);
            x=x+step;
        }
        System.out.println("Массив A:");

        int countLengthForB=0;

        for (int i = 0; i <arrayZ.length; i++) {

            if (arrayZ[i]>3.5) countLengthForB = countLengthForB + 1;

            if (i%5==0&&i!=0){
                System.out.println();
                System.out.printf("A [%2d] = %2.7f  ",i,arrayZ[i]);
            } else {

                System.out.printf("A [%2d] = %2.7f  ",i, arrayZ[i]);
            }
        }

        System.out.println();
        System.out.println("Массив B из элементов массива А, больших чем 3.5:");

        double [] arrayB = new double[countLengthForB];
        int count = 0;

        for (double v : arrayZ) {

            if (v > 3.5) {

                if (count % 5 == 0 && count != 0) {
                    arrayB[count] = v;
                    System.out.println();
                    System.out.printf("B [%2d] = %2.7f  ", count, arrayB[count]);
                } else {

                    arrayB[count] = v;
                    System.out.printf("B [%2d] = %2.7f  ", count, arrayB[count]);
                }
                count++;
            }

        }
        double mul = 1;
        for (double v : arrayB) {
            mul = mul * v;
        }

        double geometricMean;
        geometricMean=Math.pow(mul, 1.0/arrayB.length);
        System.out.println();
        System.out.println("Среднее геометрическое ="+ geometricMean);

    }
}
