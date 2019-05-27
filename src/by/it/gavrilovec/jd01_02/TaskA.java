package by.it.gavrilovec.jd01_02;
import java.util.Scanner;
public class TaskA {

    private static void step1(int[ ] mas){
        int max=mas[0];
        int min=mas[0];
        for(int i:mas){
            if (max<i) max=i;
            if(min>i) min=i;
        }
        System.out.println(min+" "+max);
    }

   private static void step2(int[ ] mas){
        double sum=0;
        for(int i:mas){
            sum+=i;
        }
        for(int i:mas) {
            if(i < sum / mas.length) System.out.print(i+" ");
        }
        System.out.println();
    }

    private static void step3(int[ ] mas){
        int min=mas[0];
        for(int i:mas){
            if(min>i) min=i;
        }
        for(int i=mas.length-1;i>=0;i--){
            if(mas[i]==min) System.out.print(i+" ");
        }
        System.out.println();

    }

    public static void main(String[] args) {
        int[] arr=new int[10];
        Scanner scan=new Scanner(System.in);
        for(int i=0;i<arr.length;i++){
            arr[i]=scan.nextInt();
        }
        step1(arr);
        step2(arr);
        step3(arr);


    }
}
