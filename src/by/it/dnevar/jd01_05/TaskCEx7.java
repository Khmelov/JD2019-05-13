package by.it.dnevar.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskCEx7 {
    public static void main(String[] args) {
        double[] arrayA = new double[31];
        int arrayBsize = 0;
        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = round(random()*450+103);
            if(arrayA[i]/10<i){
                arrayBsize++;
            }
        }

        double[]arrayB = new double[arrayBsize];
        int count = 0;
        for (int i = 0; i < arrayA.length; i++) {
            if(arrayA[i]/10<i){
                arrayB[count] = arrayA[i];
                count++;
            }
        }

        Arrays.sort(arrayB);

        System.out.println("Массив A[]");
        for (int i = 0; i < arrayA.length; i++) {
            if(i%5==0&&i!=0){
                System.out.println();
                System.out.printf("A [ %2d]=%1.1f   ",i,arrayA[i]);
            } else{
                System.out.printf("A [ %2d]=%1.1f   ",i,arrayA[i]);
            }
        }

        System.out.println();
        System.out.println("Массив B[]");
        int index1=0;
        int index2=0;
        int forCount = 0;
        if(arrayB.length%2==0){
            forCount=index2=arrayB.length/2;
        }else{
            forCount=index2=(int)(arrayB.length/2)+1;
        }

        for (int i = 0; i <forCount; i++) {
            if(i!=arrayB.length/2){
                System.out.printf("B [ %2d]=%1.1f   B [ %2d]=%1.1f   ",index1,arrayB[index1],index2,arrayB[index2]);
                System.out.println();
                index1++;
                index2++;
            }else{
                System.out.printf("B [ %2d]=%1.1f                    ",index1,arrayB[index1]);
            }

        }

    }
}
