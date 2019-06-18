package by.it.buymistrov.jd01_13;

import by.it.buymistrov.jd01_01.Main;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {

    private static ArrayList<Double> inWork = new ArrayList<>();

    private static void readData() throws RuntimeException, InterruptedException {
        Double i;
        int ts = 0;
        Scanner sc = new Scanner(System.in);
        while (true) {
            try {
                i = Double.parseDouble(sc.nextLine());
                inWork.add(i);
                System.out.println("add");
            } catch (NumberFormatException e) {
                Thread.sleep(100);

                System.out.println(TaskC.class.getName());
                ts++;
                for (int i1 = inWork.size() - 1; i1 >= 0; i1--) {
                    System.out.print(inWork.get(i1) + " ");
                }
                System.out.println();
                if (ts == 5) {
                    throw new RuntimeException();
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            readData();
        } catch (NumberFormatException e) {
            System.out.println("tixuy");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
