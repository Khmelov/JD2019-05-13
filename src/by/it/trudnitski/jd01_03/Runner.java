package by.it.trudnitski.jd01_03;
/**
 * @author Rudnitski Timofei
 * @version 1.0
 */

import java.util.Scanner;

/**
 * Запускающий класс Runner
 */
public class Runner {


    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        double[] array = InOut.getArray(str);
        double [] arr1 = InOut.getArray(str);
        /**
         * @param array массив с которым работаем
         */
        InOut.printArray(array);
        InOut.printArray(array, "A", 3);
        Helper.findMax(array);
        Helper.findMin(array);
        Helper.sort(array);


    }
}
