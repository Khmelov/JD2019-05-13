package by.it.izaykoff.jd01_04;

import by.it.izaykoff.jd01_03.InOut;


public class TaskC {
    public static void main(String[] args) {
        String line = "5 6 8 9 8 2 6 5 4 3";
        buildOneDimArray(line);

    }

    private static void buildOneDimArray(String line) {
        double[] array = InOut.getArray(line);
        InOut.printArray(array, "V", 5);
        double first = array[0];
        double last = array[array.length - 1];
//        Helper.sort(array);
        mergeSort(array);

        InOut.printArray(array);
        InOut.printArray(array, "V", 4);
        int indexFirst = binarySearch(array, first);
        int indexLast = binarySearch(array, last);
        System.out.println("Index of first element=" + indexFirst);
        System.out.println("Index of last element=" + indexLast);

    }

    private static void mergeSort(double[] array) {
        if (array == null) return;

        if (array.length < 2) return;

        double[] arrayLeft = new double[array.length / 2];
        System.arraycopy(array, 0, arrayLeft, 0, array.length / 2);

        double[] arrayRight = new double[array.length - array.length / 2];
        System.arraycopy(array, array.length / 2, arrayRight, 0, array.length - array.length / 2);

        mergeSort(arrayLeft);
        mergeSort(arrayRight);
        merge(array,arrayLeft,arrayRight);


    }


//     static double[] mergeSort(double[] array, double[] left, double[] right){
//        if(array == null) return null;
//
//        if(array.length < 2) return array;
//
//        double[] arrayLeft = new double[array.length / 2];
//        System.arraycopy(array,0,arrayLeft,0,array.length/2);
//
//        double[] arrayRight = new double[array.length - array.length/2];
//        System.arraycopy(array,array.length/2,arrayRight,0,array.length-array.length/2);
//
//        mergeSort(arrayLeft);
//        mergeSort(arrayRight);
//
//        return merge(arrayLeft,arrayRight);
//
//    }


//        private static double[] merge(double[] arrayLeft, double[] arrayRight){
//        double[] mergeArray = new double[arrayLeft.length + arrayRight.length];
//        int elementLeft = 0, elementRight = 0;
//
//        for (int i = 0; i < mergeArray.length; i++) {
//            if(elementLeft == arrayLeft.length){
//                mergeArray[i] = arrayRight[i-elementRight];
//                elementRight++;
//            } else if(elementRight == arrayRight.length){
//                mergeArray[i] = arrayLeft[i-elementLeft];
//                elementLeft++;
//            } else if(arrayLeft[i-elementLeft] < arrayRight[i-elementRight]){
//                mergeArray[i] = arrayLeft[i-elementLeft];
//                elementRight++;
//            } else {
//                mergeArray[i] = arrayRight[i-elementRight];
//                elementLeft++;
//            }
//        }
//        return mergeArray;
//    }

    private static int binarySearch(double[] array, double value){
        int res=0;
        int firstIndex  = 0;
        int lastIndex   = array.length - 1;
        int middleIndex = (firstIndex + lastIndex)/2;
        while( firstIndex <= lastIndex ) {
            if ( array[middleIndex] < value ){
                firstIndex = middleIndex + 1;
            } else if ( array[middleIndex] == value ) {
                res = middleIndex;
                break;
            } else{
                lastIndex = middleIndex - 1;
            }
            middleIndex = (firstIndex + lastIndex)/2;
        }
        return res;
    }



    private static void merge(double[] array, double[] arrayLeft, double[] arrayRight) {
        int elementArray = arrayLeft.length + arrayRight.length;
        int i, elementLeft, elementRight;
        i = elementLeft = elementRight = 0;
        while (i < elementArray) {
            if ((elementLeft < arrayLeft.length) && (elementRight < arrayRight.length)) {
                if (arrayLeft[elementLeft] < arrayRight[elementRight]) {
                    array[i] = arrayLeft[elementLeft];
                    i++;
                    elementLeft++;
                } else {
                    array[i] = arrayRight[elementRight];
                    i++;
                    elementRight++;
                }
            } else {
                if (elementLeft >= arrayLeft.length) {
                    while (elementRight < arrayRight.length) {
                        array[i] = arrayRight[elementRight];
                        i++;
                        elementRight++;
                    }
                }
                while (elementLeft < arrayLeft.length) {
                    array[i] = arrayLeft[elementLeft];
                    elementLeft++;
                    i++;
                }
            }
        }
    }



}
