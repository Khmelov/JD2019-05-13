package by.it.gavrilovec.jd01_05;

import java.util.Random;

public class TaskC {

    public static void main(String[] args) {
        Random rand=new Random();
        int size=rand.nextInt(21)+20;
        double [] arr=new double [size];
        double lowBorderOfRange=5.33;
        double highBorderOfRange=9;
       double delta=(highBorderOfRange-lowBorderOfRange)/(size-1);
       String name="A";
       int counter=0;
         for(int i=0;i<arr.length;i++){
           arr[i]=Math.cbrt(Math.pow(lowBorderOfRange,2)+4.5);
           lowBorderOfRange+=delta;
           if(arr[i]>3.5) counter++;
           System.out.printf("%s[%-2d]=%-15f",name,i,arr[i]);
            if(i%5==4) System.out.println();
       }
        System.out.println();
        double[] arrNew=new double[counter];
         counter=0;
         String nameNew="B";
         double geometricMean=1;
         for(double element:arr){
             if(element>3.5){
                 arrNew[counter]=element;
                 geometricMean*=element;
                 System.out.printf("%s[%-2d]=%-15f",nameNew,counter,arrNew[counter]);
                 if(counter%5==4) System.out.println();
                 counter++;
                 if(counter==arrNew.length) break;
             }
         }
        System.out.println();
        System.out.printf("geometric mean = %f",Math.pow(geometricMean,1.0/counter));


    }
}
