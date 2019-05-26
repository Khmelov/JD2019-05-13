package by.it.yaskevich.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        int[] mas = new int[10];

        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        
        step1(mas);
        step2(mas);
        step3(mas);
    }

    private static void step3(int[] mas) {
        int min = Integer.MAX_VALUE;
        for (int ma : mas) {
            if (min > ma)
                min = ma;
        }

        for (int i = mas.length - 1; i >= 0; i--) {
            if (min == mas[i])
                System.out.print(i + " ");
        }
    }

    private static void step2(int[] mas) {
        double sum = 0.0;
        for (int ma : mas) {
            sum += ma;
        }
        double avg = sum / mas.length;
        for (int ma : mas) {
            if (ma < avg)
                System.out.println(ma);
        }
    }

    private static void step1(int[] mas) {
        int min = mas[0], max = mas[0];
        for (int ma : mas) {
            if (min > ma) min = ma;
            if (max < ma) max = ma;
        }

        System.out.println(min + " " + max);
    }
}
