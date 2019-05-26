package by.it.yakimovich.jd01_03;

import java.util.Scanner;


public class Runner {
    public static void main(String[] args) {
    Scanner scanner=new Scanner(System.in);
    String str=scanner.nextLine();
    double[] array=InOut.getArray(str);
    InOut.printArray(array);
    InOut.printArray(array,"V",5);
    Helper.findMin(array);
        Helper.findMax(array);
        Helper.sort(array);
        int a,b,c;
         a=scanner.nextInt();
         b=scanner.nextInt();
         c=scanner.nextInt();
        double[][] matrix= new double[a][b];
        double[] vector=new double[c];
       Helper.mul(matrix,vector);

       int s,f,g,d;
        s=scanner.nextInt();
        f=scanner.nextInt();
        g=scanner.nextInt();
        d=scanner.nextInt();
        double[][] matrixLeft= new double[s][f];
        double[][] matrixRight=new double[g][d];
        Helper.mul(matrixLeft,matrixRight);

    }


}
