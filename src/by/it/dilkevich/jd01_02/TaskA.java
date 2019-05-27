package by.it.dilkevich.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int [] mas = new int[10];
        for (int i = 0; i < mas.length; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        step3(mas);
    }

    static void step1(int[ ] mas){
        int masMin = mas[0];
        int masMax = mas[0];
        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < masMin)
                masMin = mas[i];
            if (mas[i] > masMax)
                masMax = mas[i];
        }
        System.out.print(masMin + " " + masMax);
        System.out.println();

    }
    static void step2(int[ ] mas){
        double avr = 0;

        for (int i = 0; i < mas.length; i++) {
             avr += mas[i];
        }
        avr = avr / mas.length;

        for (int i:mas) {
            if(i < avr)
                System.out.print(i + " ");
        }
    }
    static void step3(int[ ] mas){
        int masMin = mas[0];

        for (int i = 0; i < mas.length; i++) {
            if (mas[i] < masMin)
                masMin = mas[i];
        }

        for (int i = mas.length-1; i >= 0; i--) {
            if (mas[i] == masMin)
                System.out.print(i + " ");
        }
    }

}
