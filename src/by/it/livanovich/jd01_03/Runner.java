package by.it.livanovich.jd01_03;


import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        double[] array = InOut.getArray(str);
        InOut.printArray(array);
        InOut.printArray(array,"v",3);
        double min = Helper.findMin(array);
        System.out.println("Минимальное значение: "+min);
        double max = Helper.findMax(array);
        System.out.println("Максимальное значение: "+max);
        Helper.sort(array);
        InOut.printArray(array);
        InOut.printArray(array,"v", 4);
        double [][] matrix= {{2,3,4}, {4,3,5}};
        double [] vector= {7,4,3};
        Helper.mul(matrix,vector);
        double [][] matrixLeft= {{2,8,4},{1,2,4}};
        double [][] matrixRight= {{5,2,5},{3,5,8}};
        Helper.mul(matrixLeft, matrixRight);
    }
}
