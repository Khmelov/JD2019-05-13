package by.it.buymistrov.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {


        int[] m = new int[10];
        Scanner sc = new Scanner(System.in);
        //int i=sc.nextInt();
        for (int i = 0; i < m.length; i++) {
            m[i] = sc.nextInt();
        }
        step1(m);
        step2(m);
        step3(m);

    }

    private static void step1(int[] m) {
        int max = m[0];
        int min = m[0];
        for (int value : m) {
            if (max < value) max = value;
            if (min > value) min = value;
        }
        System.out.println(min + " " + max);
    }

    private static void step2(int[] m) {
        int sum = 0;
        for (int value : m) {
            sum = sum + value;
        }
        double avg = sum / m.length;
        for (int value : m) {
            if (value < avg)
                System.out.print(value + " ");

        }
        System.out.println(avg);
    }

    private static void step3(int[] m) {

        int min = m[0];
        for (int value : m) {
            if (min > value) min = value;
        }
        for (int i = m.length-1; i >=0; i--)
        {
            if (m[i] == min)
                System.out.print(i+ " ");

        }
    }

}