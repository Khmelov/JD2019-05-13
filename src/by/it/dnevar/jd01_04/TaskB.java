package by.it.dnevar.jd01_04;

import by.it.dnevar.jd01_03.InOut;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int numPeople = sc.nextInt();

        System.out.println("Введите фамилии: ");
        String[] lName = new String[numPeople];
        for (int i = 0; i < lName.length; i++) {
            lName[i] = sc.next();
        }


        int[][] wage = new int[numPeople][4];
        for (int i = 0; i < wage.length; i++) {
            System.out.print("Введите зарплату для "+lName[i]+": ");
            for (int j = 0; j < wage[i].length; j++) {
                wage[i][j]=sc.nextInt();
            }

        }
        System.out.println("------------------------------------------------------------\n" +
                "Фамилия   Квартал1  Квартал2  Квартал3  Квартал4  Итого     \n" +
                "------------------------------------------------------------\n");
        int allSum = 0;
        for (int i = 0; i < wage.length; i++) {
            System.out.printf("%10s ",lName[i]+":");
            int sum = 0;
            for (int j = 0; j < wage[i].length; j++) {
                System.out.printf("%-10d",wage[i][j]);
                sum = sum + wage[i][j];
                allSum = allSum + wage[i][j];
            }
            System.out.printf("%-10d",sum);
            System.out.println();
        }
        double avValue =Math.round(((double) allSum/((wage.length)*(wage[0].length)))*10000.0)/10000.0;
        System.out.println("------------------------------------------------------------");
        System.out.printf("%-10s%-10d","Итого:",allSum);
        System.out.println();
        System.out.printf("%-10s%-10f","Средняя:",avValue);


    }
}
