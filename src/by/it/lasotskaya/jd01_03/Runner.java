package by.it.lasotskaya.jd01_03;
import java.util.Scanner;
/**
 * Class is for running all methods
 * @version 1.0
 */
public class Runner {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String str=sc.nextLine();
      double[] arr= InOut.getArray(str);
       InOut.printArray(arr);
       InOut.printArray(arr,"mas",4);
        System.out.println("Минимум " +Helper.findMin(arr));
        System.out.println("Максимум " +Helper.findMax(arr));
        Helper.sort(arr);
        System.out.println();
        double[][] array = {{1.0, 2.0, 3.0}, {3.0, 4.0, 5.0}};
        double[][] array2 = {{1.0, 2.0, 3.0}, {3.0, 4.0, 5.0}};
        double[] vector = {1.0, 2.0, 3.0};
        Helper.mul(array,vector);
        Helper.mul(array,array2);

    }
}
