package by.it.maniuk.jd01_01;

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
        Scanner scanner = new Scanner(System.in);
        int[] a = new int[2];
        for (int i = 0 ; i < 2; i++ ){
            a[i] = scanner.nextInt();
        }
        System.out.println(a[0]);
        System.out.println(a[1]);
        System.out.println("DEC:" + a[0] + "+" + a[1] + "=" + (a[0]+a[1]));
        System.out.println("BIN:" + ( Integer.toBinaryString(a[0]) + "+" + Integer.toBinaryString(a[1]) + "="
                + Integer.toBinaryString(a[0]+a[1])));
        System.out.println("HEX:" + Integer.toHexString(a[0]) + "+" + Integer.toHexString(a[1]) + "="
                + Integer.toHexString(a[0]+a[1]));
        System.out.println("OCT:" + Integer.toOctalString(a[0]) + "+" + Integer.toOctalString(a[1] )+ "="
                + Integer.toOctalString(a[0]+a[1]));
    }


}
