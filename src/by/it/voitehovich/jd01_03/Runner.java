package by.it.voitehovich.jd01_03;
import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str = sc.nextLine();

        double [] mas = InOut.getArray(str);
        InOut.printArray(mas);
        InOut.printArray(mas,"V",3);

        double min = Helper.findMin(mas);
        System.out.println(min);
        double max = Helper.findMax(mas);
        System.out.println(max);

        Helper.sort(mas);
        InOut.printArray(mas);

        double [][] matrix;
        double [] vector;
        double [] result;
        matrix=InOut.setArray();
        vector=InOut.setArrayVector();
        result = Helper.mul(matrix,vector);
        InOut.printArray(result,"V",1);

        double[][] leftMatrix = {
                {1, 2, 3},
                {4, 5, 6}

        };

        double[][] rightMatrix = {
                {1, 2},
                {4, 5},
                {7, 8}
        };

        double [][] mulResult = Helper.mul(leftMatrix, rightMatrix);
        InOut.printArray2D(mulResult,"Z");
    }





}
