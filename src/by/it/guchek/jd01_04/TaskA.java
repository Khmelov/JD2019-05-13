package by.it.guchek.jd01_04;

import java.util.Scanner;

public class TaskA {
    private static void printMulTable(){
        for (int i = 2; i <10 ; i++) {
            for (int j = 2; j <10 ; j++) {
                System.out.printf("%1d*%1d=%-2d ",i,j,i*j);
            }
            System.out.println();

        }
    }
    private static void buildOneDimArray(String line){

        double[] array = InOut.getArray(line);
        double start=array[0];            //заранее запоминаем начальное значение первого элемента до сортировки
        double finish=array[array.length-1]; //заранее запоминаем начальное значение последнего элемента до сортировки
        InOut.printArray(array, "V",5);
        Helper.sort(array);
        InOut.printArray(array, "V", 4);
        for (int i = 0; i < array.length; i++) {   //ищем новый индекс первого элемента
            if (array[i]==start){
                System.out.println("index of first element="+i);
                break;
            }

        }
        for (int i = 0; i < array.length; i++) {
            if (array[i]==finish){
                System.out.println("index of last element="+i);
                break;
            }

        }
        //int indexFirst= Arrays.binarySearch(array,index): ЛУЧШИЙ поиск индекса элемента
    }

    public static void main (String[] args){
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
       // String line = {1 4 5 4 2 };
        buildOneDimArray(str);

    }

}
