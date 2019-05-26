package by.it.izaykoff.jd01_03;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String i = sc.nextLine();

        double[] ent = InOut.getArray(i);
        InOut.printArray(ent);
        InOut.printArray(ent,"x",4);

        System.out.println( Helper.findMax(ent));
        System.out.println( Helper.findMin(ent));
        Helper.sort(ent);


        double[][] matrrixL = {
                {1,2,3,4},
                {5,6,7,8}
        };
        double[][] matrrixR = {
                {1,2},
                {5,6}
        };
        double[] vector = {9,8,7,6};
        double[] sumMatrixVector = Helper.mul(matrrixL,vector);
        double[][] sumMatrix = Helper.mul(matrrixL, matrrixR);
        InOut.printArray(sumMatrixVector);
        InOut.printArray(sumMatrix);


    }
}
