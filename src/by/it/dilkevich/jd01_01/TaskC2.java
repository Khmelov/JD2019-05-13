package by.it.dilkevich.jd01_01;

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
        int firstNumber = scanner.nextInt();
        int secondNumber = scanner.nextInt();
        int sum = firstNumber + secondNumber;

        System.out.println("DEC:" + firstNumber + "+" + secondNumber + "=" + sum);
        System.out.println("BIN:" + Integer.toBinaryString(firstNumber) + "+" + Integer.toBinaryString(secondNumber) + "=" + Integer.toBinaryString(sum));
        System.out.println("HEX:" + Integer.toHexString(firstNumber) + "+" + Integer.toHexString(secondNumber) + "=" + Integer.toHexString(sum));
        System.out.println("OCT:" + Integer.toOctalString(firstNumber) + "+" + Integer.toOctalString(secondNumber) + "=" + Integer.toOctalString(sum));
    }

}
