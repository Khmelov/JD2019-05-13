package by.it.yaskevich.jd01_01;

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
        int i = scanner.nextInt();
        int j = scanner.nextInt();
        int s = i + j;

        System.out.printf("DEC:%d+%d=%d\n", i, j, s);
        System.out.printf("BIN:%s+%s=%s\n",
                Integer.toBinaryString(i), Integer.toBinaryString(j), Integer.toBinaryString(s));
        System.out.printf("HEX:%h+%h=%h\n", i, j, s);
        System.out.printf("OCT:%o+%o=%o\n", i, j, s);
    }
}
