package by.it.akhmelev.jd01_07;

import java.util.Scanner;

public class Runner {

    public static void main(String[] args) {
        Vector v1=new Vector(new double[]{1,2,3});
        System.out.println(v1);

        Vector v2=new Vector(v1);
        System.out.println(v2);

        v1.reset();
        System.out.println(v2);

    }
}
