package by.it.orlov.jd01_03;

import java.util.Arrays;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        double[] array = InOut.getArray(line);
        System.out.println(Arrays.toString(array));
        InOut.printArray(array);
        InOut.printArray(array, "A", 3);
        Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
    }
}
