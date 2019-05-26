package by.it.voitehovich.jd01_02;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] mas = new int[10];
        System.out.println("Введите 10 целых чисел:");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = sc.nextInt();
        }

        step1(mas);
        step2(mas);
        step3(mas);

    }

    private static void step1(int[] mas) {
        int max = mas[0];
        int min = mas[0];
        for (int value : mas) {
            if (max < value) max = value;
            if (min > value) min = value;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] mas) {
        double avg = 0;
        for (int value : mas)
            avg = avg + value;
        avg = avg / mas.length;
        for (int value : mas) if (value < avg) System.out.print(value + " ");
        System.out.println();
    }

    private static void step3(int[] mas){
        int min = mas[0];
        for (int value : mas) if(min> value) min = value;
        for (int i = mas.length -1 ; i >= 0 ; i--) {
            if (mas[i] == min) System.out.print(i + " ");
        }
        }
    }
