package by.it.izaykoff.jd01_05;
import java.util.Arrays;

import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {
        task1();
        task2();
    }

    private static void task1(){

        int elements = (int) (random()*((40-20) + 1))+20;
        double[] array = new double[elements];
        double[] arrayMiddle = new double[elements];
        int countArMid=0;
        double middleArf = 1.0;
        double x = 5.33;
        for (int i = 0; i < array.length ; i++) {
            array[i] = cbrt(pow(x,2)+4.5);

            if(i%5 == 0 && i != 0){
                System.out.println();
                System.out.printf("M[%-2d]=%f ",i,array[i]);
            } else System.out.printf("M[%-2d]=%f ",i,array[i]);

            if(array[i] > 3.5 ){
               arrayMiddle[i] = array[i];
               middleArf *= arrayMiddle[i];
               countArMid++;
            }
            x += (9-5.33)/array.length;
        }
        double sum = pow(middleArf, 1.0/countArMid);
        System.out.printf("\nсреднее геометрическое значение %1.1f\n",sum);

    }

    private static void task2(){
        int[] arrayA = new int[31];
        int countA = 0;
        System.out.println("Массив А");
        System.out.print("┏━━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━━┓\n");

        for (int i = 0; i < arrayA.length; i++) {
            arrayA[i] = (int) (random()*((450-103) + 1));
            if (arrayA[i]/10 < i){
                countA++;
            }
            if (i%5 == 0 && i != 0){
                System.out.print("\n┗━━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━━┛\n");
                System.out.print("┏━━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━━┓\n");
                System.out.printf("┃A [%-2d]=%-4d┃ ",i,arrayA[i]);
            }else{
                System.out.printf("┃A [%-2d]=%-4d┃ ",i,arrayA[i]);

            }
        }
        System.out.print("\n┗━━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━━┛\n");

        System.out.println("\nМассив В");
        int[] arrayB = new int[countA];
        int countB = 0;
        for (int i = 0; i < arrayA.length; i++) {

            if (arrayA[i]/10 < i){
                arrayB[countB] = arrayA[i];
                countB++;
            }
        }
        Arrays.sort(arrayB);
        printTwoRow(arrayB);
    }

    private static void printTwoRow(int[] array){
        int index1=0;
        int index2;
        int forCount;
        if(array.length%2 == 0){
            forCount = index2 = array.length/2;
        }else{
            forCount = index2 = array.length/2+1;
        }
        System.out.print("┏━━━━━━━━━━━━┓ ┏━━━━━━━━━━━━┓\n");
        for (int i = 0; i < forCount; i++) {
            if(i != array.length/2){
                System.out.printf("┃B [%-2d]=%-3d┃ ",index1,array[index1]);
                System.out.printf("┃B [%-2d]=%-3d┃",index2,array[index2]);

                System.out.println();
                index1++;
                index2++;
            }else   System.out.printf("┃B [%-2d]=%-3d┃ ",index1,array[index1]);

        }
        System.out.print("\n┗━━━━━━━━━━━━┛ ┗━━━━━━━━━━━━┛");
    }

}

