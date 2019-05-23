package by.it.guchek.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main (String [] args){

        Scanner scanner=new Scanner (System.in); // Создала объект сканера
        int [] mas=new int [10]; //Обьявила массив в 10 чисел
        for (int i = 0; i < mas.length; i++) { //Заполняем массив вводом с клавиатуры через пробел
            mas[i]=scanner.nextInt();
        }
        step1(mas); //Вызываю метод step1 чтобы он заработал и передаю туда прочитанный с клавы массив
        step2(mas);
        step3(mas);
    }

    private static void step1 (int [] mas) {  //Саздала статический метод step1
       int min=mas[0]; // задала минимуму первое число массива
       int max=mas[0];                               //обрабатываю то,что мы получили из методв mаin
        for (int i = 0; i <mas.length ; i++) {
            if (min>mas[i]) min=mas[i];
            if (max<mas[i]) max=mas[i];
        }

        System.out.println(min+" "+max);

    }
    private static void step2 (int [] mas) {
        double avg=0;
        for (int i = 0; i <mas.length ; i++) {

            avg=avg+mas[i]; //сумма всех элементов массива
        }
        avg=avg/mas.length; //среднее арифметическое чисел массива
        for (int i = 0; i <mas.length ; i++) {
            if (mas[i]<avg)   //если элемент массива меньше среднего арифметического
            System.out.print(mas[i]+" "); // выводим на консоль
        }


    }
     private static void step3 (int [] mas) {
         int min=mas[0]; // задала минимуму первое число массива
                               
         for (int i = 0; i <mas.length ; i++) {
             if (min>mas[i]) min=mas[i];
         }
        // System.out.println("Минимум "+min);
        for (int i = mas.length-1; i>=0; i--) {
             if (mas[i]==min)
             System.out.print(i+" ");
             
         }


    }

}
