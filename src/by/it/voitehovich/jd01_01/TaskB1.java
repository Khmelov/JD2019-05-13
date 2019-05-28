package by.it.voitehovich.jd01_01;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите целое число:");
        int number = sc.nextInt();
        System.out.println("Квадрат этого числа равен: " + number*number);
    }
}
