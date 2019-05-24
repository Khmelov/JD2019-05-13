package by.it.tbabich.jd01_05;

import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {
        step1(5.33, 9, 0.2);
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
    }

    private static void printArray(double[] arrayA, String name) {
        System.out.printf("Массив %s[]\n", name);
        for (int i = 0; i < arrayA.length; i++) {
            System.out.printf("%s[%2d] = %-10.5f", name, i, arrayA[i]);
            if ((i + 1) % 5 == 0) System.out.println();
        }
    }
}
