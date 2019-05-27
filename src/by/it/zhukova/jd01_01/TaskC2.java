package by.it.zhukova.jd01_01;

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
        int a=sc.nextInt();
        int b=sc.nextInt();
        int k = a+b;
        System.out.println("DEC:" + a + "+" + b + "=" + k );
        System.out.print("BIN:");
        step1( a, b, k,2);
        System.out.print("HEX:");
        step1(a, b, k, 16);
        System.out.print("OCT:");
        step1(a, b, k, 8);

    }

    private static void step1(int a,int b, int k, int n) {

        System.out.println(Integer.toString(a,n) + "+" + Integer.toString(b,n) + "=" + Integer.toString(k,n));
    }
}
