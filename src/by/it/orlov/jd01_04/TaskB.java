package by.it.orlov.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        int year = 0;
        Scanner scn = new Scanner(System.in);
        int count = scn.nextInt();
        String[] sur_name = new String[count];
        String[] form = {"Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого"};

        int[][] mas = new int[count][5];
        //вношу фамилии
        for (int i = 0; i < sur_name.length; i++) {
            sur_name[i] = scn.next();
        }

        //вношу зп квартал и год
        for (int i = 0; i < sur_name.length; i++) {
            System.out.println("Введите зарплату для " + sur_name[i]);
            for (int j = 0; j < mas[i].length; j++) {
                if(j > 3){
                    mas[i][j] = year;
                    year = 0;
                }else {
                    mas[i][j] = scn.nextInt();
                    year += mas[i][j];
                }
            }
        }

        //Вывожу
        printAll(sur_name, mas, form);

    }
    static void printAll(String[] sur_name, int[][] mas, String[] form){
        int res = 0;
        double res_avg = 0;
        System.out.println("----------------------------------------------------------------");
        for (String s : form) {
            System.out.printf("%-10s",s);
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < sur_name.length; i++) {
            System.out.printf("%-10s%-10d%-10d%-10d%-10d%-10d",sur_name[i],mas[i][0],mas[i][1],mas[i][2],mas[i][3],mas[i][4]);
            System.out.print("\n");
        }
        System.out.println();
        System.out.println("----------------------------------------------------------------");
        for (int i = 0; i < mas.length; i++) {
            res += mas[i][4];
        }
        System.out.printf("%-10s%-10d","Итого",res);
        res_avg = (double) res / 4 / sur_name.length;
        System.out.println();
        System.out.printf("%-10s%-10.3f","Средняя",res_avg);

    }

    }

