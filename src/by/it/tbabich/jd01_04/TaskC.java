package by.it.tbabich.jd01_04;

import java.util.Arrays;

public class TaskC {
    public static void main(String[] args) {
        buildOneDimArray("-14.793907351863504 -0.5423896440347438 -1.1974799601312718 1.3647098251327883 -14.950026426854082 -4.6845775894474535 13.01147317191888 4.775970031281556 -6.262203306663849 6.7346753759847005 -14.112249060306457 -8.047378162740753 3.7347886757845394 -2.0142547576606944 5.442735007430542");
    }

    static void buildOneDimArray(String line) {

        double[] array = InOut.getArray(line);
        double first = array[0];
        double last = array[array.length - 1];

        InOut.printArray(array, "V", 5);
        System.out.println();

        mergeSort(array);

        InOut.printArray(array, "V", 4);
        System.out.println();

        System.out.println("Index of first element=" + binarySearch(array, first));
        System.out.println("Index of last element=" + binarySearch(array, last));


    }

    static void mergeSort(double[] array) {
        double[] buffer1 = Arrays.copyOf(array, array.length);
        double[] buffer2 = new double[array.length];
        double[] result = merge(buffer1, buffer2, 0, array.length);
        System.arraycopy(result, 0, array, 0, array.length);
    }

    static double[] merge(double[] part1, double[] part2, int left, int right) {
        if (left >= right - 1) {
            return part1;
        }

        // уже отсортирован.
        int middle = left + (right - left) / 2;
        double[] sorted1 = merge(part1, part2, left, middle);
        double[] sorted2 = merge(part1, part2, middle, right);

        // Слияние
        int index1 = left;
        int index2 = middle;
        int destIndex = left;
        double[] result = sorted1 == part1 ? part2 : part1;
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

    static int binarySearch(double[] array, double value, int left, int right) {
        int middle = left + (right - left) / 2;
        if (value < array[middle]) return binarySearch(array, value, left, middle - 1);
        if (value > array[middle]) return binarySearch(array, value, middle + 1, right);
        else return middle;
    }
}