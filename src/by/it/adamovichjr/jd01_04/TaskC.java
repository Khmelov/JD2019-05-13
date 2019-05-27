package by.it.adamovichjr.jd01_04;

import by.it.adamovichjr.jd01_03.InOut;

public class TaskC {
    public static void main(String[] args) {
        String test = "12 65 52 3 89 21 56 41 69 88 12 8 25 32 33";
        buildOneDimArray(test);
    }


    public static void mergeSort(double[] array){

        int low = 0;
        int high = array.length-1;
        mergeSort(array,low,high);
    }


    static void mergeSort(double[] array, int low, int high) {

        int partition = partition(array, low, high);
        if(partition-1 > low) {
            mergeSort(array, low, partition - 1);
        }
        if(partition+1<high) {
            mergeSort(array, partition + 1, high);
        }
    }


    static int partition(double[] array,int low, int high) {

        double pivot = array[high];
        for(int i = low; i < high; i++){
            if(array[i] < pivot){
                double temp = array[low];
                array[low] = array[i];
                array[i] = temp;
                low++;
            }
        }
        double temp = array[low];
        array[low] = pivot;
        array[high] = temp;
        return low;
    }


    public static int binarySearch(double[] array, double value){

        int indexBegin = 0;
        int indexEnd = array.length-1;
        int indexMiddle;
        int valueIndex = -1;
        while(indexBegin <= indexEnd) {

            indexMiddle = (indexBegin + indexEnd) / 2;

            if (value < array[indexMiddle]) {
                indexEnd = indexMiddle - 1;
            }
            else if (value > array[indexMiddle]) {
                indexBegin = indexMiddle + 1;
            }
            if (array[indexMiddle] == value) {
                valueIndex = indexMiddle;
                break;
            }
        }

        return valueIndex;
    }


    public static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array,"V",5);
        double first = array[0];
        double last = array[array.length-1];
        mergeSort(array);
        System.out.println();
        InOut.printArray(array,"V",4);
        System.out.println();
        int indexFirst = binarySearch(array,first);
        int indexLast = binarySearch(array,last);
        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);


    }
}

