package by.it.trudnitski.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[]names=new String[n];
        for (int i = 0; i <names.length; i++) {
            names[i] = sc.next();
        }
        int[][] salary=new int[n][4];
        for (int i = 0; i < names.length; i++) {
            System.out.printf("Введите зарплату для %s\n",names[i]);
            for (int j = 0; j < salary[i].length; j++) {
                salary[i][j]=sc.nextInt();
            }
        }
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.printf("%-10s%-10s%-10s%-10s%-10s%-10s\n",
                "Фамилия", "Квартал1", "Квартал2", "Квартал3", "Квартал4", "Итого");
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        int sum=0;
        int res=0;
        int k=0;
        for (int i = 0; i < salary.length; i++) {
            System.out.printf("%-10s",names[i]);
            for (int j = 0; j < salary[i].length; j++) {
                System.out.printf("%-10d",salary[i][j]);
               sum+=salary[i][j];
                              k++;
            }
            res=res+sum;
            System.out.printf("%-10d",sum);
            sum=0;
            System.out.println();
        }
        double middle = (double)res / k;
        System.out.println("_ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ ");
        System.out.printf("%-10s%-10d%n%-10s%-10.3f","Итого",res,"Средняя",middle);




    }
}
