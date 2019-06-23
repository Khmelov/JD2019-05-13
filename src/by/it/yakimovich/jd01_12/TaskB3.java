package by.it.yakimovich.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class TaskB3 {
    private static ArrayList<String> aList = new ArrayList<>();
    private static LinkedList<String>  lList = new LinkedList<>();


    public static class Timer{
        private long iniTime;
        private Double Delta;
        public Timer() {
            iniTime = System.nanoTime();
                    }
        public String toString (){
            Delta=(double) (System.nanoTime()-iniTime)/1000;
            iniTime=System.nanoTime();
            return "Прошло "+Delta.toString()+" микросекунд";
        }

   }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            aList.add(i + 1 + "");
            lList.add(i + 1 + "");

        }
        System.out.println(aList);
        System.out.println(lList);
        System.out.println(process(aList));
        System.out.println(process(lList));
        Timer timer = new Timer();
        System.out.println(process(aList));
        System.out.println("Время ArrayList"+timer);
        System.out.println(process(lList));
        System.out.println("Время LinkedList"+timer);
    }

    static String process(ArrayList<String> aList) {
        int pos = 0;
        while (aList.size() != 1) {
            pos = (pos + 1) % aList.size();
            aList.remove(pos);
        }
        return aList.get(0);
    }

    static String process(LinkedList<String> lList) {
        int pos = 0;
        while (lList.size() != 1) {
            pos = (pos + 1) % lList.size();
            lList.remove(pos);
        }
        return lList.get(0);
    }
}



