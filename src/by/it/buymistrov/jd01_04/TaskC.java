package by.it.buymistrov.jd01_04;

import java.util.Arrays;

public class TaskC {

    /**
     * формирует из строки line массив вещественных чисел, сортирует его функциекией mergeSort,  ищет индексы первого и последнего элементов.
     *
     * @param line строка, которая преобразуется в массив, отсортируется
     */
    static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);

        double first = array[0];
        double last = array[array.length - 1];

        System.out.println();
        System.out.println();
        mergeSort(array);
        System.out.println();


        int newIndexFirst = binarySearch(array, first);
        System.out.println("new Index of first element=" + newIndexFirst);
        int newIndexLast = binarySearch(array, last);
        System.out.println("new Index of last element=" + newIndexLast);


    }


    /**
     * сортировка слиянием
     *
     * @param array массив типа double
     */

    private static void mergeSort(double[] array) {
        double[] toBeSort = Arrays.copyOf(array, array.length);
        double[] toBeSortBak = new double[array.length];
        double[] result = mergeSort(toBeSort, toBeSortBak, 0, array.length);
        System.arraycopy(result, 0, array, 0, result.length);
        System.out.println(Arrays.toString(result));

    }

    /**
     * @param toBeSort    Массив для сортировки.
     * @param toBeSortBak Буфер. Размер должен быть равен размеру toBeSort.
     * @param left        Начальный индекс в toBeSort для сортировки.
     * @param right       Конечный индекс в toBeSort для сортировки.
     * @return
     */
    private static double[] mergeSort(double[] toBeSort, double[] toBeSortBak, int left, int right) {
        if (left >= right - 1) {
            return toBeSort;                // готово
        }


        int middle = left + (right - left) / 2;
        double[] sorted1 = mergeSort(toBeSort, toBeSortBak, left, middle);
        double[] sorted2 = mergeSort(toBeSort, toBeSortBak, middle, right);

        // Слияние \/

        int index1 = left;
        int index2 = middle;
        int destIndex = left;

        double[] result = sorted1 == toBeSort ? toBeSortBak : toBeSort;
        while (index1 < middle && index2 < right) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < right) {
            result[destIndex++] = sorted2[index2++];
        }

        return result;
    }


    static int binarySearch(double[] array, double value) {

        return binarySearch(array, value, 0, array.length);
    }

    static int binarySearch(double[] array, double value, int first, int last) {

        if (first > last) return -1;
        int cent = first + (last - first) / 2;

        if (value < array[cent]) {
            return binarySearch(array, value, first, cent - 1);
        } else if (value > array[cent]) {
            return binarySearch(array, value, cent + 1, last);
        } else {
            return cent;
        }

    }


    public static void main(String[] args) {
        String line = "-3 4 5 -6 7 -7 7 8 9 0 -1 2";
        buildOneDimArray(line);


    }
}
