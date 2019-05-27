package by.it.izaykoff.jd01_01;

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
        Scanner sc = new Scanner(System.in);
        System.out.print("Введите два чила (через пробел): ");
        int i = sc.nextInt();
        int i2 = sc.nextInt();
        int sum = i + i2;

        System.out.println("DEC:" + i +"+"+ i2 +"="+ sum);
        System.out.println("BIN:" + Integer.toString(i,2)+"+"+Integer.toString(i2,2)+"="+Integer.toString(sum,2));
        System.out.println("HEX:" + Integer.toString(i,16)+"+"+Integer.toString(i2,16)+"="+Integer.toString(sum,16));
        System.out.println("OCT:" + Integer.toString(i,8)+"+"+Integer.toString(i2,8)+"="+Integer.toString(sum,8));

    }


}
