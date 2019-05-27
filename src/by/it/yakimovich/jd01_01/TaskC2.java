package by.it.yakimovich.jd01_01;

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
        int i=sc.nextInt();
        int y=sc.nextInt();
        int m=i+y;
        System.out.print("DEC:");
        System.out.println(i+ "+" +y+"="+m);
        System.out.print("BIN:");
        System.out.println(Integer.toBinaryString(i)+ "+" +Integer.toBinaryString(y)+"="+Integer.toBinaryString(m));
        System.out.print("HEX:");
        System.out.println(Integer.toHexString(i)+ "+" +Integer.toHexString(y)+"="+Integer.toHexString(m));
        System.out.print("OCT:");
        System.out.println(Integer.toOctalString(i)+ "+" +Integer.toOctalString(y)+"="+Integer.toOctalString(m));
    }


}
