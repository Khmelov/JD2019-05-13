package by.it.izaykoff.jd01_05;
import static java.lang.Math.*;


public class TaskC {
    public static void main(String[] args) {
        task1();
    }

    private static void task1(){
        double[] array = new double[20];
        double[] arrayMiddle = new double[20];
        int i=0;
        int j=0;
        double middleArf = 1.0;
        for (double x = 5.33; x <= 9 ; x++) {
            array[i] = cbrt(pow(x,2)+4.5);
            System.out.printf("M [%2d ] = %f\n",i,array[i]);
            if(array[i] > 3.5 ){
               arrayMiddle[i] = array[i];
               middleArf *= arrayMiddle[i];
               j++;
            }
            i++;
        }
        double sum = pow(middleArf, 1.0/j);
        System.out.println("средн. геометр. = " + sum);


    }

}

