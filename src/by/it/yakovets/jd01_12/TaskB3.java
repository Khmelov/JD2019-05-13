package by.it.yakovets.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskB3 {
    private static void prn(Object o) {
        System.out.println(o.toString());
    }

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list1 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(i + 1 + "");
            list1.add(i + 1 + "");
        }
        Timer t = new Timer();
        System.out.println(list);
//        System.out.println("Печать ArList " + t);
        System.out.println(list1);
//        System.out.println("Печать LinkedList " + t);



        System.out.println(process(list));
        System.out.println("ArList " + t);
        System.out.println(process(list1));
        System.out.println("LinkedList " + t);


    }

    static String process(ArrayList<String> list) {
        int counter = 1;
        while (list.size() > 1) {
            Iterator<String> it = list.iterator();
            if (counter != 1) {
                counter = counter - list.size();
            }
            while (it.hasNext()) {
                if (list.indexOf(it.next()) == counter) {
                    it.remove();
                    counter++;
                }
            }

        }
        return list.get(0);
    }

    static String process(LinkedList<String> list) {
        int counter = 1;
        while (list.size() > 1) {
            Iterator<String> it = list.iterator();
            if (counter != 1) {
                counter = counter - list.size();
            }
            while (it.hasNext()) {
                if (list.indexOf(it.next()) == counter) {
                    it.remove();
                    counter++;
                }
            }

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
