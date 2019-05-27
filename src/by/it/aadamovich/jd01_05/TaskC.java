package by.it.aadamovich.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {

        task6();
        task7();


    }

    private static void task6() {

        int number = (int) (random() * (40 - 20 + 1)) + 20;
        double increment = (9 - 5.33) / (number - 1);

        double[] arrayA = new double[number];
        double x = 5.33;
        int count = 0; // calculates arrayB length

        System.out.println("Массив А");
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = cbrt(pow(x, 2) + 4.5);
            System.out.printf("A[%3d] = %.5f ", i, arrayA[i]);
            x += increment;

            if ((i + 1) % 5 == 0) System.out.println();

            if (arrayA[i] > 3.5) count++;
        }
        System.out.println('\n');

        double[] arrayB = new double[count];
        double multi = 1; // multiplication of arrayB elements
        int index = 0;

        System.out.println("Массив В из элементов массива А больше 3.5");

        for (double v : arrayA) {
            if (v > 3.5) {
                arrayB[index] = v;
                multi *= arrayB[index];

                System.out.printf("B[%3d] = %.5f ", index, arrayB[index]);

                index++;
            }
            if (index % 5 == 0 && index != 0) System.out.println();
        }
        System.out.printf("%nСреднее геометрическое элементов массива B: %g%n", pow(multi, 1.0 / arrayB.length));
    }

    private static void task7() {

        // constructors for upper parts
        StringBuilder aUp = new StringBuilder("\u2554\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566");
        StringBuilder bUp = new StringBuilder("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2566");
        StringBuilder cUp = new StringBuilder("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2557");
        //constructors for middle parts
        StringBuilder aMid = new StringBuilder("\u2560\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256c");
        StringBuilder bMid = new StringBuilder("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u256c");
        StringBuilder cMid = new StringBuilder("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2563");
        // constructors for lower parts
        StringBuilder aDown = new StringBuilder("\u255a\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569");
        StringBuilder bDown = new StringBuilder("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2569");
        StringBuilder cDown = new StringBuilder("\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u2550\u255d");
        // array A parts
        StringBuilder wideUp = new StringBuilder();
        wideUp.append(aUp).append(bUp).append(bUp).append(bUp).append(cUp);
        StringBuilder wideMid = new StringBuilder();
        wideMid.append(aMid).append(bMid).append(bMid).append(bMid).append(cMid);
        StringBuilder wideDown = new StringBuilder();
        wideDown.append(aDown).append(bDown).append(bDown).append(bDown).append(cDown);
        // array B parts
        StringBuilder narrowUp = new StringBuilder();
        narrowUp.append(aUp).append(cUp);
        StringBuilder narrowMid = new StringBuilder();
        narrowMid.append(aMid).append(cMid);
        StringBuilder narrowDown = new StringBuilder();
        narrowDown.append(aDown).append(cDown);

        System.out.println("Massiv M <index to rows>");
        System.out.println(wideUp.toString());

        int[] arrayA = new int[31];
        int count = 0;              // calculates array B length
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) (random() * (450 - 103 + 1)) + 103;
            System.out.printf("\u2551 M[%2d]=%3d ", i + 1, arrayA[i]);

            if ((i + 1) % 5 == 0) {
                System.out.printf("\u2551%n");
                System.out.println(wideMid.toString());
            }
            if (arrayA.length - 1 == i) {
                System.out.printf("\u2551%11s\u2551%11s\u2551%11s\u2551%11s\u2551%n", " ", " ", " ", " ");
                System.out.println(wideDown.toString());
            }
            if ((0.1 * arrayA[i]) > i) count++;
        }

        int[] arrayB = new int[count];
        int index = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if ((0.1 * arrayA[i]) > i) {
                arrayB[index] = arrayA[i];
                index++;
            }
        }

        Arrays.sort(arrayB);

        System.out.println("Massiv B <index to cols>");
        System.out.println(narrowUp.toString());
        int half = arrayB.length / 2 + arrayB.length % 2;
        for (int i = 0; i < half; i++) {
            if ((i == half - 1) && (arrayB.length % 2 != 0)) {
                System.out.printf("\u2551 B[%2d]=%3d \u2551%11s\u2551%n", i + 1, arrayB[i], " ");
                break;
            }
            if ((i == half - 1) && (arrayB.length % 2 == 0)) {
                System.out.printf("\u2551 B[%2d]=%3d \u2551 B[%2d]=%3d \u2551%n", i + 1, arrayB[i], i + 1 + half, arrayB[half + i]);
               break;
            }

            System.out.printf("\u2551 B[%2d]=%3d \u2551 B[%2d]=%3d \u2551%n", i + 1, arrayB[i], i + 1 + half, arrayB[half + i]);
            System.out.println(narrowMid.toString());
        }
        System.out.println(narrowDown.toString());
    }
}



