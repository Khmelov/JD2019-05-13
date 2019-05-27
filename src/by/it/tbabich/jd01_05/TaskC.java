package by.it.tbabich.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {
        step1(5.33, 9, 0.2);
        System.out.println();
        step2();
    }

    static void step1(double left, double right, double step) {
        double[] arrayA;
        double[] arrayB;
        int sizeArrayA = 0;
        int sizeArrayB = 0;
        for (double x = left; x <= right; x += step) {
            sizeArrayA++;
            if (cbrt(pow(x, 2) + 4.5) > 3.5) sizeArrayB++;
        }
        arrayA = new double[sizeArrayA];
        arrayB = new double[sizeArrayB];

        int countArrayA = 0;
        int countArrayB = 0;
        double multiplication = 1;
        for (double x = left; x <= right; x += step) {
            double y = cbrt(pow(x, 2) + 4.5);
            arrayA[countArrayA++] = y;
            if (cbrt(pow(x, 2) + 4.5) > 3.5) {
                arrayB[countArrayB++] = y;
                multiplication *= y;
            }
        }

        printArray(arrayA, "A");
        System.out.println("\n");
        printArray(arrayB, "B");
        System.out.println();
        System.out.printf("%s = %-10.5f", "Среднее геометрическое элементов массива B[]", pow(multiplication, 1.0 / sizeArrayB));
        System.out.println();
    }

    static void step2() {
        int[] A = new int[31];
        int sizeArrayB = 0;
        for (int i = 0; i < A.length; i++) {
            int k = (int) round(random() * 347 + 103);
            A[i] = k;
            if (k * 0.1 > i) sizeArrayB++;
        }

        int countB = 0;
        int[] B = new int[sizeArrayB];
        for (int i = 0; i < A.length; i++) {
            if (A[i] * 0.1 > i) B[countB++] = A[i];
        }

        formatPrint(A, "A", 5, true);
        System.out.println();
        Arrays.sort(B);
        formatPrint(B, "B", 2, false);
    }

    private static void printArray(double[] array, String name) {
        System.out.printf("Массив %s[]\n", name);
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%2d] = %-10.5f", name, i, array[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }

    static void formatPrint(int[] array, String name, int count, boolean isRows) {
        String s;
        if (isRows) s = "rows";
        else s = "cols";
        System.out.printf("Massiv %s (index to %s)\n", name, s);
        printTop(count);
        if (isRows) printArrayBetweenTopAndBottomToRows(array, name, count);
        else printArrayBetweenTopAndBottomToCols(array, name);
        System.out.println();
        printBottom(count);
    }

    private static void printTop(int count) {
        System.out.print('\u2554');
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('\u2550');
            }
            if (i == count - 1) break;
            System.out.print('\u2566');
        }
        System.out.print('\u2557');
        System.out.println();
        System.out.print('\u2551');
    }

    private static void printArrayBetweenTopAndBottomToRows(int[] array, String name, int count) {
        for (int i = 0; i < array.length; i++) {
            System.out.printf("%s[%2d]=%4d", name, i, array[i]);
            System.out.print('\u2551');
            if (i == array.length - 1 && array.length % count == 0) continue;
            if ((i + 1) % count == 0) {
                System.out.println();
                System.out.print('\u2560');
                for (int k = 0; k < count; k++) {
                    for (int f = 0; f < 10; f++) {
                        System.out.print('\u2550');
                    }
                    if (k == count - 1) break;
                    System.out.print('\u256c');
                }
                System.out.print('\u2563');
                System.out.println();
                System.out.print('\u2551');
            }
        }
        if (array.length % count != 0) {
            for (int i = count; i > array.length % count; i--) {
                System.out.printf("%10s", " ");
                System.out.print('\u2551');
            }
        }
    }

    private static void printArrayBetweenTopAndBottomToCols(int[] array, String name) {
        for (int i = 0; i < array.length / 2; i++) {
            System.out.printf("%s[%2d]=%4d", name, i, array[i]);
            System.out.print('\u2551');
            if (i + array.length / 2 <= array.length - 1)
                System.out.printf("%s[%2d]=%4d", name, i + array.length / 2, array[i + array.length / 2]);
            System.out.print('\u2551');
            if (i == array.length / 2 - 1) continue;
            System.out.println();
            System.out.print('\u2560');
            for (int k = 0; k < 2; k++) {
                for (int f = 0; f < 10; f++) {
                    System.out.print('\u2550');
                }
                if (k == 2 - 1) break;
                System.out.print('\u256c');
            }
            System.out.print('\u2563');
            System.out.println();
            System.out.print('\u2551');

        }
    }

    private static void printBottom(int count) {
        System.out.print('\u255A');
        for (int i = 0; i < count; i++) {
            for (int j = 0; j < 10; j++) {
                System.out.print('\u2550');
            }
            if (i == count - 1) break;
            System.out.print('\u2569');
        }
        System.out.print('\u255D');
    }
}
