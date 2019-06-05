package by.it.guchek.jd01_01;

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

        int [] mas=new int [2]; //Обьявила массив в 10 чисел
        for (int i = 0; i < mas.length; i++) { //Заполняем массив вводом с клавиатуры через пробел
            mas[i]=scanner.nextInt();}
        int sum=mas[0]+mas[1] ;
        System.out.println("DEC:"+mas[0]+"+"+mas[1]+"="+sum);
        System.out.println("BIN:"+Integer.toBinaryString(mas[0])+"+"+Integer.toBinaryString(mas[1])+"="+Integer.toBinaryString(sum));
        System.out.println("HEX:"+Integer.toHexString(mas[0])+"+"+Integer.toHexString(mas[1])+"="+Integer.toHexString(sum));
        System.out.println("OCT:"+Integer.toOctalString(mas[0])+"+"+Integer.toOctalString(mas[1])+"="+Integer.toOctalString(sum));
        // System.out.println(Integer.toOctalString(mas[0])); Восьмиричный
      //  System.out.println(Integer.toHexSring(i)); шестнадцатиричный
    }
}

