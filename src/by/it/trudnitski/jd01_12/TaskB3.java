package by.it.trudnitski.jd01_12;

import java.util.*;

public class TaskB3 {


    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                if (count != 1) {
                    count = count - peoples.size();
                }
                while (iterator.hasNext()) {
                    if (peoples.indexOf(iterator.next()) == count) {
                        iterator.remove();
                        count++;
                    }
                }
            }
        }
        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            for (int i = 0; i < peoples.size(); i++) {
               if(i%2 != 0){
                   peoples.remove(i);
               }
            }
        }

        return peoples.get(0);
    }


    public static void main(String[] args) {
        Timer t = new Timer();
        Integer[] arr = new Integer[4097];
        for (int i = 1; i <= 4096; i++) {
            arr[i] = i;
        }
        List<?> arrayList = new ArrayList<>(Arrays.asList(arr));
        List<?> linkedList = new LinkedList<>(Arrays.asList(arr));
        System.out.println("ИСкомый элемент" + process((ArrayList<String>) arrayList));
        System.out.println(t);
        System.out.println("ИСкомый элемент" + process((LinkedList<String>) linkedList));
        System.out.println(t);

    }

    public static class Timer {
        private long iniTimer;
        private Double Delta;

        public Timer() {
            iniTimer = System.nanoTime();
        }

        public String toString() {
            Delta = (double) (System.nanoTime() - iniTimer) / 1000;
            iniTimer = System.nanoTime();
            return "Прошло " + Delta.toString() + " Микросекунд";
        }
    }

}
