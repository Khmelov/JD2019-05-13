package by.it.yaskevich.jd01_05;

import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        task6();
        task7();
    }

    private static void task7() {
        int[] array = getArrayA();

        String line = new String(new char[65]).replace("\0", "\u2550");
        StringBuilder a = getLongLineUp(line);
        StringBuilder b = getLongLineMiddle(line);
        StringBuilder c = getLongLineDown(line);

        printArrayA(array, a, b, c);

        int[] bb = getArrayB(array);
        Arrays.sort(bb);

        line = new String(new char[26]).replace("\0", "\u2550");
        a = getSmallLineUp(line);
        b = getSmallLineMiddle(line);
        c = getSmallLineDown(line);

        printArrayB(bb, a, b, c);
    }

    private static void printArrayB(int[] bb, StringBuilder a, StringBuilder b, StringBuilder c) {
        System.out.println(a);

        int half = bb.length / 2 + bb.length % 2;
        for (int j = 0; j < half; j++) {
            System.out.printf("\u2551 B[%2d]=%d \u2551", j + 1, bb[j]);
            if ((half + j) < bb.length) {
                System.out.printf(" B[%2d]=%d \u2551\n", half + j + 1, bb[half + j]);
            } else
                System.out.println("           \u2551");

            if (j < (half - 1))
                System.out.println(b);
            else {
                System.out.println(c);
            }
        }
        System.out.println();
    }

    private static void printArrayA(int[] array, StringBuilder a, StringBuilder b, StringBuilder c) {
        System.out.println(a);

        int i = 0;
        int delta = 5 - (array.length % 5);
        while (i < (array.length + delta)) {
            if (i < array.length) {
                if ((i == 0) || ((i + 1) % 5 == 1))
                    System.out.print("\u2551");
                System.out.printf(" M[%2d]=%d \u2551", i + 1, array[i]);
                if ((i + 1) % 5 == 0) {
                    System.out.println();
                    System.out.println(b);
                }
            } else {
                System.out.print("           \u2551");
            }
            i++;
        }
        System.out.println();
        System.out.println(c);
        System.out.println();
    }

    private static StringBuilder getSmallLineDown(String line) {
        StringBuilder c;
        c = new StringBuilder(line)
            .replace(0, 0, "\u255a")
            .replace(14, 14, "\u2569")
            .replace(28, 28, "\u255d");
        return c;
    }

    private static StringBuilder getSmallLineMiddle(String line) {
        StringBuilder b;
        b = new StringBuilder(line)
            .replace(0, 0, "\u2560")
            .replace(14, 14, "\u256c")
            .replace(28, 28, "\u2563");
        return b;
    }

    private static StringBuilder getSmallLineUp(String line) {
        StringBuilder a;
        a = new StringBuilder(line)
            .replace(0, 0, "\u2554")
            .replace(14, 14, "\u2566")
            .replace(28, 28, "\u2557");
        return a;
    }

    private static StringBuilder getLongLineDown(String line) {
        return new StringBuilder(line)
                .replace(0, 0, "\u255a")
                .replace(14, 14, "\u2569")
                .replace(28, 28, "\u2569")
                .replace(42, 42, "\u2569")
                .replace(56, 56, "\u2569")
                .replace(70, 70, "\u255d");
    }

    private static StringBuilder getLongLineMiddle(String line) {
        return new StringBuilder(line)
                .replace(0, 0, "\u2560")
                .replace(14, 14, "\u256c")
                .replace(28, 28, "\u256c")
                .replace(42, 42, "\u256c")
                .replace(56, 56, "\u256c")
                .replace(70, 70, "\u2563");
    }

    private static StringBuilder getLongLineUp(String line) {
        StringBuilder a = new StringBuilder(line);
        a.replace(0, 0, "\u2554");
        a.replace(14, 14, "\u2566");
        a.replace(28, 28, "\u2566");
        a.replace(42, 42, "\u2566");
        a.replace(56, 56, "\u2566");
        a.replace(70, 70, "\u2557");
        return a;
    }

    private static int[] getArrayB(int[] array) {
        int counter = 0;
        for (int j = 0; j < array.length; j++) {
            if ((array[j] * 0.1) > j)
                counter++;
        }

        int k = 0;
        int[] bb = new int[counter];
        for (int j = 0; j < array.length; j++) {
            if ((array[j] * 0.1) > j) {
                bb[k] = array[j];
                k++;
            }
        }
        return bb;
    }

    private static int[] getArrayA() {
        Random random = new Random();

        int[] array = new int[31];
        for (int i = 0; i < array.length; i++) {
            array[i] = 103 + random.nextInt(450 - 103 + 1);
        }
        return array;
    }

    private static void task6() {
        Random random = new Random();
        int n = 20 + random.nextInt(40 - 20 + 1);
        double delta = (9 - 5.33) / (n - 1);

        double[] array = getArray(n, delta);

        printArray(array);
        printArrayOnlyMore35(array);
        printGeometricAvr(array);
    }

    private static void printGeometricAvr(double[] array) {
        System.out.println("Среднее геометрическое");
        double g = 1.0;
        for (double anArray : array) {
            g *= anArray;
        }
        g = pow(g, 1.0 / array.length );
        System.out.printf("g=%f\n", g);
    }

    private static double[] getArray(int n, double delta) {
        double[] a = new double[n];
        double x = 5.33;
        for (int i = 0; i < a.length; i++) {
            a[i] = cbrt(x * x + 4.5);
            x += delta;
        }
        return a;
    }

    private static void printArray(double[] array) {
        System.out.print("Массив A[]");
        for (int j = 0; j < array.length; j++) {
            if (j % 5 == 0)
                System.out.println();
            System.out.printf("%s[% 3d] = %.5f ", "A", j, array[j]);
        }
        System.out.println();
    }

    private static void printArrayOnlyMore35(double[] array) {
        System.out.print("Массив B[] из элементов массива A > 3.5");
        int i = 0;
        for (double anArray : array) {
            if (anArray > 3.5) {
                if (i % 5 == 0)
                    System.out.println();
                System.out.printf("%s[% 3d] = %.5f ", "B", i++, anArray);
            }
        }
        System.out.println();
    }
}
