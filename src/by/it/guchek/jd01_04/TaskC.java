package by.it.guchek.jd01_04;

import java.util.Arrays;
import java.util.Scanner;


public class TaskC {
    public static void main (String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        buildOneDimArray(str);


    }

        static void buildOneDimArray (String line) {

            double[] array = InOut.getArray(line);
            double start = array[0];            //заранее запоминаем начальное значение первого элемента до сортировки
            double finish = array[array.length - 1]; //заранее запоминаем начальное значение последнего элемента до сортировки
            InOut.printArray(array, "V", 5);
            //Helper.sort(array);
            mergeSort(array);

           /*static int binarySearch(double[] array, double value){
                //double start = array[0];            //заранее запоминаем начальное значение первого элемента до сортировки
                //double finish = array[array.length - 1];
                int indexOne=Arrays.binarySearch(array, start);
                int indexTwo=Arrays.binarySearch(array, finish);
                return;

            } */

            InOut.printArray(array, "V", 4);
            for (int i = 0; i < array.length; i++) {   //ищем новый индекс первого элемента
               if (array[i] == start) {
                    System.out.println("index of first element=" + i);
                    break;
                }

            }
            for (int i = 0; i < array.length; i++) {
                if (array[i] == finish) {
                    System.out.println("index of last element=" + i);
                    break;
                }

            }
        }
                                //int indexFirst= Arrays.binarySearch(array,index): ЛУЧШИЙ поиск индекса элемента
            static void mergeSort ( double[] array){
                Arrays.sort(array);
                for (double v : array) {
                    System.out.print(v);
                }


            }
    /*static int binarySearch(double[] array, double value){
        double start = array[0];            //заранее запоминаем начальное значение первого элемента до сортировки
        double finish = array[array.length - 1];
        int indexOne=Arrays.binarySearch(array, start);
        int indexTwo=Arrays.binarySearch(array, finish);
    }*/

}
