package by.it.adamovichjr.jd01_05;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    private static void step1() {
        double step = 0.15;
        int n = (int) ceil((9 - 5.33) / 0.15);
        double[] first = new double[n];
        int i = 0;
        for (double x = 5.33; x <= 9; x = x + step) {
            first[i] = cbrt(x * x + 4.5);
            System.out.printf("z[% -3d] = %-10.6f", i, first[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
            i++;
        }
        System.out.println();
        System.out.println();
        int j = 0;
        for (double elem : first) {
            if (elem > 3.5) {
                j++;
            }
        }
        double sum = 1;
        double[] second = new double[j];
        int j1 = 0;
        for (double elem : first) {
            if (elem > 3.5) {
                second[j1] = elem;
                sum *= second[j1];
                System.out.printf("z1[% -3d] = %-10.6f", j1, second[j1]);
                if ((j1 + 1) % 5 == 0) {
                    System.out.println();
                }
                j1++;
            }
        }
        System.out.println();
        System.out.println();
        double geom = pow(sum, (1.0 / second.length));
        System.out.println("Среднее геометрическое =" + geom);
        System.out.println();

    }

    private static void step2() {
        Random random = new Random();
        double[] masM = new double[31];
        System.out.println("Massiv M <index to rows>");
        for (int i = 0; i < masM.length; i++) {
            masM[i] = random.nextInt(347) + 103;
            System.out.printf("M[%2d] = %-6.2f", i, masM[i]);
            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }

        int j = 0;
        for (int i = 0; i < masM.length; i++) {
            if (masM[i] / 10 > i) {
                j++;
            }
        }
        double[] masB = new double[j];
        j = 0;
        for (int i = 0; i < masM.length; i++) {
            if (masM[i] / 10 > i) {
                masB[j] = masM[i]/10;
                j++;
            }
        }
        Arrays.sort(masB);
        System.out.println();
        System.out.println();
        System.out.println("Massiv B <index to cols>");
        if (masB.length%2 == 0){
            for (int i = 0; i < masB.length/2; i++) {
                System.out.printf("B[%2d] = %-6.2f B[%2d] = %-6.2f\n", i, masB[i],i + masB.length/2,masB[i+ masB.length/2]);
            }
        }
        else {
            for (int i = 0; i < (masB.length+1)/2; i++) {
                if(i < masB.length/2) {
                    System.out.printf("B[%2d] = %-6.2f B[%2d] = %-6.2f\n", i, masB[i],i + masB.length/2+1,masB[i+ masB.length/2+1]);
                }
                else{
                    System.out.printf("B[%2d] = %-6.2f\n",i,masB[i]);
                    break;
                }


            }
        }

    }


    public static void main(String[] args) {
        step1();
        step2();

    }


}