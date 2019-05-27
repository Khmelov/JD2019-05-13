package by.it.yakovets.jd01_03;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        double[] arr = InOut.getArray(str);
        InOut.printArray(arr);
        InOut.printArray(arr, "V", 3);
        System.out.println(Helper.findMin(arr));
        System.out.println(Helper.findMax(arr));
        Helper.sort(arr);
        InOut.printArray(arr);
    }
}
