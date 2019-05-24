package by.it.zhukova.jd01_05;
import java.util.Arrays;

import static java.lang.Math.*;
public class TaskC {
    public static void main(String[] args) {
        double[] z = math6step1();
        math6step2(z);
        math7step1();
    }
    private static double [ ] math6step1() {

        int n = (int)(random()*20+20);
        double [ ] arr = new double[n];
        double x = 0;
        System.out.println("Массив:");
        for (int i = 0; i < n; i++) {
do {x = random()*3.67+5.33;}
while (x>9);
arr [i] = pow((pow(x,2)+4.5),1.0/3.0);
            System.out.printf("z[% -3d]=%-8.5f", i, arr[i]);
            if ((i+1)%5==0 ) System.out.println();
        }
        System.out.println();
        return arr;
    }
    private static void math6step2(double[] z) {
        double key = 3.5;
        double buffer = 0;
        int j = 0;
        for (int i = 0; i < z.length; i++) {
            if (z[i]<=key) {
                buffer = z[j];
                z[j]=z[i];
                z[i] = buffer;
                j=j+1;
            }
        }
        double[] result = new double [z.length-j];
        System.arraycopy(z,j,result,0,result.length);
        double middl = 0;
        double mult = 1;
        System.out.println("Массив из элементов > 3.5");
        for (int i = 0; i < result.length; i++) {
            mult *= result[i];
            System.out.printf("z[% -3d]=%-8.5f", i, result[i]);
            if ((i+1)%5==0 ) System.out.println();
        }
        middl = pow ( mult, 1.0/result.length);
        System.out.printf("\nсреднее геометрическое = %1f\n",middl);
    }
    private static void math7step1() {
   int n= 31;
    int [] arr = new int [n];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(random()*348+103);
            System.out.printf("A[ %-3d]=%-8d", i, arr[i]);
            if ((i+1)%5==0 ) System.out.println();
        }
        int [] arrB = new int[n];
        int j=0;
        for (int i = 0; i < arr.length; i++) {
           if (arr[i]*0.1 > i ) {
               arrB[j]=arr[i];
               j++;
           }
        }
        int[] B = Arrays.copyOf(arrB, j);
        Arrays.sort(B);
int k = 7;
        for (int i = 0; i < k; i++) {
            System.out.printf("\nB[ %-3d]=%-8d", i, B[i]);
           j=i+k;
            while (j<B.length) {
                System.out.printf("B[ %-3d]=%-8d", j, B[j]);
                j+=k;
            }

            }

        }

    }

