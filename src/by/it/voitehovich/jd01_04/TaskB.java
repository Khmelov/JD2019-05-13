package by.it.voitehovich.jd01_04;
import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number = sc.nextInt();
        int sumSalary = 0;
        double avg = 0;
        String [] secondName = new String[number];
        for (int i = 0; i < number; i++) {
            secondName[i] = sc.next();
        }

        int [][] salary = new int[number][4];
        for (int i = 0; i <salary.length; i++) {
            System.out.println("Введите зарплату для " + secondName[i]);
            for (int j = 0; j <salary[0].length ; j++) {
                salary[i][j] = sc.nextInt();
            }
        }
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-10s %-8s %-8s %-8s %-8s %-8s %n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < salary.length; i++) {
            int sum = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
                System.out.printf("%-10s %-8d %-8d %-8d %-8d %-6d %n", secondName[i], salary[i][0],
                        salary[i][1],salary[i][2],salary[i][3], sum );
        }
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i <salary.length ; i++) {
            for (int j = 0; j <salary[0].length ; j++) {
                sumSalary += salary[i][j];
            }
        }
        avg = (double)sumSalary / (number *4);
        System.out.printf("%-10s%-4d%n", "Итого", sumSalary);
        System.out.printf("%-10s%-11.6f%n", "Средняя", avg);
    }
}
