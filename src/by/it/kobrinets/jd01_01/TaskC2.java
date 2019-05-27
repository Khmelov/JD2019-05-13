package by.it.kobrinets.jd01_01;

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
        int a = sc.nextInt();
        int b = sc.nextInt();
        int sum = a + b;

        String sumBin = Integer.toBinaryString(Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b)));
        String sumHex = Integer.toHexString(Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b)));
        String sumOct = Integer.toOctalString(Integer.parseInt(String.valueOf(a)) + Integer.parseInt(String.valueOf(b)));

        System.out.println("DEC:" + a + "+" + b + "=" + sum);
        System.out.println("BIN:" + Integer.toBinaryString(a) + "+" + Integer.toBinaryString(b) + "=" + sumBin);
        System.out.println("HEX:" + Integer.toHexString(a) + "+" + Integer.toHexString(b) + "=" + sumHex);
        System.out.println("OCT:" + Integer.toOctalString(a) + "+" + Integer.toOctalString(b) + "=" + sumOct);
    }


}
