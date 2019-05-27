package by.it.guchek.jd01_01;

import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и выводит их сумму на экран в виде

Ввод (это вы вводите с клавиатуры):
34 26

Вывод (это должна появится в консоли, обратите внимание на пробелы и слово Sum:
Sum = 60

*/
class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int [] mas=new int [2]; //Обьявила массив в 10 чисел
        for (int i = 0; i < mas.length; i++) { //Заполняем массив вводом с клавиатуры через пробел
            mas[i]=scanner.nextInt();}
        int sum=mas[0]+mas[1] ;
        System.out.println("Sum = "+sum);
    }





}
