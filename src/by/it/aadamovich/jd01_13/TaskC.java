package by.it.aadamovich.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) throws InterruptedException {
        readData();
    }

    private static void readData() throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        LinkedList<Double> list = new LinkedList<>();

        int count = 0;

        while (true) {
            try {
                list.addFirst(Double.valueOf(sc.nextLine()));
            } catch (NumberFormatException e) {
                Thread.sleep(100);
                for (Double element : list) {
                    System.out.print(element + " ");
                }
                System.out.println();
                if (++count == 5) throw e;
            }
        }
    }
}
