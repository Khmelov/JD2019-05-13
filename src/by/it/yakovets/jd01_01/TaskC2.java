package by.it.yakovets.jd01_01;

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
        int j=sc.nextInt();
        int k=i+j;
        String ibin = Integer.toBinaryString(i);
        String jbin = Integer.toBinaryString(j);
        String kbin = Integer.toBinaryString(k);
        String ihex = Integer.toHexString(i);
        String jhex = Integer.toHexString(j);
        String khex = Integer.toHexString(k);
        String ioct = Integer.toOctalString(i);
        String joct = Integer.toOctalString(j);
        String koct = Integer.toOctalString(k);
        System.out.println("DEC:"+i+"+"+j+"="+k);
        System.out.println("BIN:"+ibin+"+"+jbin+"="+kbin);
        System.out.println("HEX:"+ihex+"+"+jhex+"="+khex);
        System.out.println("OCT:"+ioct+"+"+joct+"="+koct);
    }


}
