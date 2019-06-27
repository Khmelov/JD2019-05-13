package by.it.izaykoff.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {

        Random random = new Random();
        String[] testStr = new String[4096];
        for (int i = 0; i < 4096; i++) {
            int number = 1 + random.nextInt(100);
            testStr[i] = Integer.toString(number);

        }

        ArrayList<String> peoplesArrayList = new ArrayList<>(Arrays.asList(testStr));
        LinkedList<String> peoplesLinkedList = new LinkedList<>(Arrays.asList(testStr));

        Timer timer = new Timer();

        System.out.println(process(peoplesArrayList));
        System.out.println("Время работы peoplesArrayList" + timer);
        System.out.println(process(peoplesLinkedList));
        System.out.println("Время работы peoplesLinkedList" + timer);

    }

    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
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
        return peoples.get(0);
    }

//    static String process(LinkedList<String> peoples) {
//        int count = 1;
//        while (peoples.size() > 1) {
//            Iterator<String> iterator = peoples.iterator();
//
//            if (count != 1) {
//                count = count - peoples.size();
//            }
//            while (iterator.hasNext()) {
//                if (peoples.indexOf(iterator.next()) == count) {
//                    iterator.remove();
//                    count++;
//                }
//            }
//        }
//        return peoples.get(0);
//    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            for (int i = 0; i < peoples.size(); i++) {
                if (i % 2 != 0){
                    peoples.remove(i);
                }
            }
        }
        return peoples.get(0);
    }


}
