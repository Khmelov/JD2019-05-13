package by.it.yakimovich.jd01_04;

import java.util.Scanner;
import java.util.stream.IntStream;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        String[] surname=new String[n];
        for (int i = 0; i <n ; i++) {
            surname[i]=scanner.next();
            System.out.println(surname[i]);
        }

        int m=4;
        int[][] salary=new int[n][m];

        for (int i = 0; i <salary.length ; i++) {

             System.out.println("Введите зарплату для "+surname[i]);
            for (int j = 0; j <salary[i].length ; j++) {
               salary[i][j]=scanner.nextInt();
                           }
                        }
        System.out.printf("%-9s %-9s %-9s %-9s %-9s %-9s", "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println(" ");
          for (int i = 0; i <salary.length ; i++) {
            System.out.printf("%-9s ", surname[i]);
            int sum=0;
            int summ=0;
            for (int j = 0; j <salary[i].length ; j++) {
                sum=sum+salary[i][j];
                System.out.printf("%-9d ", salary[i][j]);
                summ=summ+salary[i][j];
                                }System.out.printf("%-9s ", sum);
            System.out.println();

            }
        int summ=0;
        double avr=0;

        for (int i = 0; i <salary.length ; i++) {

            for (int j = 0; j <salary[i].length ; j++) {
                summ=summ+salary[i][j];
                avr =(double) summ / (n * 4);
            }

        }

        System.out.printf("%-9s %-9d ","Итого",summ);
        System.out.println();
        System.out.printf("%-9s %-9.6f ","Средняя",avr);

    }

                              }


            







