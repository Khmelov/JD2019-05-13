package by.it.yakovets.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list1 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(i + 1 + "");
            list1.add(i + 1 + "");

        }
        System.out.println(list);
        System.out.println(list1);
        Timer t = new Timer();
        System.out.println(process(list));
        System.out.println("Применение ArrayList"+t);
        System.out.println(process(list1));
        System.out.println("Применение LinkedList"+t);

    }

    static String process(ArrayList<String> list) {
        int pos = 0;
        while (list.size() != 1) {
            pos = (pos + 1) % list.size();
            list.remove(pos);
        }
        return list.get(0);
    }

    static String process(LinkedList<String> list) {
        int pos = 0;
        while (list.size() != 1) {
            pos = (pos + 1) % list.size();
            list.remove(pos);
        }
        return list.get(0);
    }

    public static class Timer {
        private long iniTime;
        private Double Delta;

        public Timer() {
            iniTime = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTime) / 1000;
            iniTime = System.nanoTime();

            return "Прошло " + Delta.toString() + " микросекунд.";
        }

    }

}