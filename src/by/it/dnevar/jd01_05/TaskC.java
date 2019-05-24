package by.it.dnevar.jd01_05;

import java.util.Arrays;

import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        double[] array = new double[30];
        double element = 5.33;
        System.out.println("Массив A[]");
        for (int i = 0; i < array.length; i++) {
            array[i] = cbrt(pow(element,2)+4.5);
            element+=0.1;
//            array[i] = cbrt(pow((random()*9+5.33),2)+4.5);
        }

//        Arrays.sort(array);
        for (int i = 0; i < array.length; i++) {
            if(i%5==0&&i!=0){
                System.out.println();
                System.out.printf("A [ %2d]=%1.5f   ",i,array[i]);
            } else{
                System.out.printf("A [ %2d]=%1.5f   ",i,array[i]);
            }
        }

        System.out.println("\n");

        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if(array[i]>3.5){
                count++;
            }
        }

        int index = 0;
        double sum = 1;
        double[] newArray = new double[count];
        System.out.println("Массив B[] из элементов массива A > 3.5");
        for (int i = 0; i < array.length; i++) {
            if(array[i]>3.5){
                newArray[index] = array[i];
                sum*=newArray[index];
                if(index%5==0&&index!=0){
                    System.out.println();
                    System.out.printf("B [ %2d]=%1.5f   ",index,newArray[index]);
                } else{
                    System.out.printf("B [ %2d]=%1.5f   ",index,newArray[index]);
                }
                index++;
            }
        }
        System.out.println("\n");
        System.out.println("Среднее геометрическое: "+pow(sum,1.0/count));
    }
}
