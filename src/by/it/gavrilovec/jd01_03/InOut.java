package by.it.gavrilovec.jd01_03;
import java.util.Arrays;
/**@author me)))*/
  class InOut {
    /**
     *
     * @param line Строка считаная с клавиатуры
     * @return Возвращает массив чисел, полученный из исходной строки
     */
    static double[ ] getArray(String line){
         String[] lineArray=line.trim().split("\\s+");
        double [] arr=new double[lineArray.length];
        for (int i = 0; i <arr.length ; i++) {
           arr[i]=Double.parseDouble(lineArray[i]);
           }
        return arr;
    }

    /**
     *
     * @param arr Метод выводит на печать элементы исходного массива
     */
     static void printArray(double[ ] arr){
       System.out.println( Arrays.toString(arr));
     }

    /**
     *
     * @param arr ывод на печать исходного массива
     * @param name имя массива
     * @param columnCount количество колонок при выводе массива
     */
     static void printArray(double[ ] arr, String name, int columnCount){
         for (int i = 0; i <arr.length; i++) {
             System.out.printf("%s["+"%d"+"]=%-10.1f",name,i,arr[i]);
             if(i%columnCount==3) System.out.println();
         }

     }
 }