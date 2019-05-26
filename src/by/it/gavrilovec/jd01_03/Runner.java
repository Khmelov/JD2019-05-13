package by.it.gavrilovec.jd01_03;
import java.util.Scanner;
import java.util.Random;
/**@author me)))*/
public class Runner {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        double[] arr=InOut.getArray(s);
       InOut.printArray(arr);
        int columnCount=4;
        String name="Array";
        InOut.printArray(arr,name,columnCount);
        double min=Helper.findMin(arr);
        System.out.println(min);
        double max=Helper.findMax(arr);
        System.out.println(max);
        Helper.sort(arr);
        Random rand=new Random();
        int rowsMatrix=rand.nextInt(5)+1;
        int common=rand.nextInt(5)+1;
        double[][] matrix=new double[rowsMatrix][common];
        double[] vector=new double[common];
        for (int i = 0; i <rowsMatrix ; i++) {
            for (int j = 0; j <common ; j++) {
               matrix[i][j]= rand.nextInt(9)+1;
            }
         }
        for (int i = 0; i <common ; i++) {
            vector[i]=rand.nextInt(9)+1;
        }
        double [] matrixVector=Helper.mul(matrix,vector);
        int colonsMatrix=rand.nextInt(4)+2;
        double[][] matrixAdditional=new double[common][colonsMatrix];
        for (int i = 0; i <common ; i++) {
            for (int j = 0; j <colonsMatrix ; j++) {
                matrixAdditional[i][j]= rand.nextInt(9)+1;
            }
        }
        double [][] matrixMatrix=Helper.mul(matrix,matrixAdditional);
    }
}
