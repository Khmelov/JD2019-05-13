package by.it.gavrilovec.jd01_04;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String s=scan.nextLine();
        int n=Integer.parseInt(s);
        String[] lastNames=new String[n];
        for (int i = 0; i < lastNames.length; i++) {
            lastNames[i]=scan.nextLine();
          }
        int[][] salary=new int[n][4];
        for (int i = 0; i <salary.length ; i++) {
            System.out.println("Введите зарплату для "+lastNames[i]);
            String money=scan.nextLine();
            String[] cash=money.trim().split("\\s+");
            for (int j = 0; j <salary[0].length ; j++) {
                salary[i][j]=Integer.parseInt(cash[j]);
            }
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        int sum=0;
        for (int i = 0; i <lastNames.length ; i++) {
            int sumPerson=salary[i][0]+salary[i][1]+salary[i][2]+salary[i][3];
System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n",lastNames[i],salary[i][0],salary[i][1],salary[i][2],salary[i][3],sumPerson);
        sum+=sumPerson;
        }
        System.out.println("-----------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s%-10d\n","Итого:",sum);
        double average=((double)sum)/n/4;
        System.out.printf("%-10s%.4f\n","Средняя:",average);

    }
}
