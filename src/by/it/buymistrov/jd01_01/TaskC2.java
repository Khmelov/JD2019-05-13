package by.it.buymistrov.jd01_01;

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
        int i = sc.nextInt();
        int j = sc.nextInt();
        int x = i + j;

        String ib = Integer.toBinaryString(i);
        String jb = Integer.toBinaryString(j);
        String xb = Integer.toBinaryString(x);

        String ih = Integer.toHexString(i);
        String jh = Integer.toHexString(j);
        String xh = Integer.toHexString(x);

        String io = Integer.toOctalString(i);
        String jo = Integer.toOctalString(j);
        String xo = Integer.toOctalString(x);

        System.out.println("DEC:" + i + "+" + j + "=" + x);
        System.out.println("BIN:" + ib + "+" + jb + "=" + xb);
        System.out.println("HEX:" + ih + "+" + jh + "=" + xh);
        System.out.println("OCT:" + io + "+" + jo + "=" + xo);
    }


}
