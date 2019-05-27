package by.it.orlov.jd01_02;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int month = scn.nextInt();
        int a = scn.nextInt(), b = scn.nextInt(), c = scn.nextInt();
        step1();
        step2(month);
        step3(a, b, c);
    }
    static void step1(){
        for (int i = 0; i <= 25; i++) {
            System.out.print(i+" ");
            if(i%5==0&i!=0){
                System.out.print("\n");
            }
        }


    }
    static void step2(int month){
    switch (month){
        case(1):
            System.out.println("январь");
        break;

        case(2):
            System.out.println("февраль");
            break;

        case(3):
            System.out.println("март");
            break;
        case(4):
            System.out.println("апрель");
            break;
        case(5):
            System.out.println("май");
            break;
        case(6):
            System.out.println("июнь");
            break;
        case(7):
            System.out.println("июль");
            break;
        case(8):
            System.out.println("август");
            break;
        case(9):
            System.out.println("сентябрь");
            break;
        case(10):
            System.out.println("октябрь");
            break;
        case(11):
            System.out.println("ноябрь");
            break;
        case(12):
            System.out.println("декабрь");
            break;
        default:
            System.out.println("нет такого месяца");
            break;
    }
    }


    static void step3(double a, double b, double c){
        double D = (b*b)-(4 * a * c);
        double unD = Math.sqrt(D);
        if(D>=0){
            double x_1 = ((-b) + unD)/(2 * a), x_2 = ((-b) - unD)/(2 * a);
            if(x_1!=x_2){
                System.out.print(x_1+" "+x_2);
            }else{
                System.out.println(x_1);
            }

        }else{
            System.out.print("корней нет");
        }
    }
}
