package by.it.voitehovich.jd01_01;
import java.util.Scanner;

/* Нужно написать программу, которая вводит два числа с клавиатуры
и 4 раза выводит их сумму с обозначением системы счисления на экран в
ДЕСЯТИЧНОМ ДВОИЧНОМ ШЕСТНАДЦАТИРИЧНОМ ВОСЬМИРИЧНОМ виде

Вот пример ввода с клавиатуры:
34 26

Тогда вывод ожидается такой (обратите внимание на регистр букв):
DEC:34+26=60
BIN:100010+11010=111100
HEX:22+1a=3c
OCT:42+32=74
*/
class TaskC2 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите 2 числа с клавиатуры через пробел:");
        int number1 = sc.nextInt();
        int number2 = sc.nextInt();
        int sum = number1 + number2;
        String firstSum = "DEC:" + number1  + "+" + number2 + "=" + sum;

        String secondSum = "BIN:" + Integer.toString(number1, 2)  + "+"
                                  +  Integer.toString(number2, 2) + "="
                                  +  Integer.toString(sum, 2);

        String thirdSum = "HEX:" + Integer.toString(number1, 16)  + "+"
                +  Integer.toString(number2, 16) + "="
                +  Integer.toString(sum, 16);

        String fourthSum = "OCT:" + Integer.toString(number1, 8)  + "+"
                +  Integer.toString(number2, 8) + "="
                +  Integer.toString(sum, 8);

        System.out.println(firstSum);
        System.out.println(secondSum);
        System.out.println(thirdSum);
        System.out.println(fourthSum);

    }

}
