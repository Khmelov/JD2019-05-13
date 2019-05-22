package by.it.tbabich.jd01_03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
    public static void main(String[] args) throws IOException {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader bufferedReader = new BufferedReader(reader);
        String line = bufferedReader.readLine();
        InOut.printArray(InOut.getArray(line));
        System.out.println();
        InOut.printArray(InOut.getArray(line), "v", 5);
        double array1[][] = {
                {2, 1, 3},
                {4, 5, 6}
        };
        double array2[][] = {
                {1, 3},
                {4, 2},
                {5, 1}
        };
        double[] vector = {5, 7, 9};
        Helper.mul(array1, vector);
        Helper.mul(array1, array2);
    }
}
