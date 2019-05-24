package by.it.zhukova.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        System.out.println("Введите количество сотрудников:");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("Введите "+ n + " фамилий:");
        String [] lastname = new String[n];
        for (int i = 0; i < lastname.length; i++) {
            lastname [i] = sc.next();
        }

        int[ ] [ ]  salary = new int [n] [4];
        int [ ] result = new int [n];
        int sum = 0;
        for (int i = 0; i < lastname.length; i++) {
            System.out.println("Введите зарплату для "+ lastname[i]);
            for (int j = 0; j < 4; j++) {
                salary[i][j] = sc.nextInt();
                result [i] += salary [i][j]; // расчет итоговой для одного сотрудника
            }
           sum+=result[i];// расчет итоговой для всех сотрудников
                   }
        System.out.println("--------------------------------------------------------");
        System.out.println("Фамилия    Квартал1  Квартал2  Квартал3  Квартал4  Итого");
        System.out.println("--------------------------------------------------------");
        for (int i = 0; i < lastname.length; i++) {
            System.out.printf("%9s: %-9d %-9d %-9d %-9d %d",lastname[i],salary[i][0],salary[i][1],salary[i][2],salary[i][3],result[i]);
            System.out.println();
        }
        System.out.println("--------------------------------------------------------");
        System.out.printf( "%-9s %d","Итого",sum);
        System.out.println();
        double middle = (double)sum/(n*4);
        System.out.printf(  "%-10s %-1.4f","Средняя", middle);
    }
}
