package by.it.aadamovich.jd01_03;

import java.util.Scanner;

/**
 * @ Alexey Adamovich
 *
 * @version 1
 */

public class Runner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Введите ряд чисел через пробел (дробная часть через '.'):");
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);
        InOut.printArray(array);

        System.out.println("Введите имя массива:");
        String name = sc.nextLine();
        System.out.println("Введите количество столбцов:");
        int columnCount = sc.nextInt();

        System.out.println("Массив: " + name);
        InOut.printArray(array, name, columnCount);
        System.out.println("Массив " + name + ", отсортированный по возрастанию:");
        Helper.sort(array);
        InOut.printArray(array, name, columnCount);

        System.out.println("Минимум массива " + name + ": " + Helper.findMin(array));
        System.out.println("Максимум массива " + name + ": " + Helper.findMax(array));

        System.out.println("Введите количество столбцов 1 матрицы и строк 2 матрицы(вектора):");
        int equal = sc.nextInt();
        System.out.println("Введите количество строк первой матрицы:");
        int matrixFirstSize = sc.nextInt();
        System.out.println("Введите количество столбцов второй матрицы:");
        int matrixSecondSize = sc.nextInt();
        System.out.println("Введите нижний лимит генерации чисел:");
        int lowLimit = sc.nextInt();
        System.out.println("Введите верхний лимит генерации чисел:");
        int upLimit = sc.nextInt();

        System.out.println("Вектор v:");
        double[] vector = Helper.createVector(equal);
        InOut.printArrayVector(vector, "v");
        System.out.println("Матрица m1:");
        boolean m = true;
        double[][] matrixFirst = Helper.createMatrix(equal, matrixFirstSize, m, lowLimit, upLimit);
        InOut.printArrayMatrix(matrixFirst, "m1");
        System.out.println("Матрица m2:");
        m = false;
        double[][] matrixSecond = Helper.createMatrix(equal, matrixSecondSize, m, lowLimit, upLimit);
        InOut.printArrayMatrix(matrixSecond, "m2");
        System.out.println("Результат умножения матрицы м1 на вектор v:");
        InOut.printArrayVector(Helper.mul(matrixFirst, vector), "v2");
        System.out.println("Результат умножения матрицы м1 на матрицу м2:");
        InOut.printArrayMatrix(Helper.mul(matrixFirst, matrixSecond), "m3");

    }
}

