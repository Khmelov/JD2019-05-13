package by.it.kobrinets.jd01_12;

import java.util.*;

public class TaskB3 {
    public static void main(String[] args) {

        Integer[] arr = new Integer[4097];
        for (int i = 1; i <= 4096; i++) {
            arr[i] = i;
        }


        ArrayList<?> arrList = new ArrayList<>(Arrays.asList(arr));
        LinkedList<?> linkList = new LinkedList<>(Arrays.asList(arr));

        System.out.println(process((ArrayList<String>) arrList));
        System.out.println(process((LinkedList<String>) linkList));

    }

    private static String process(ArrayList<String> people) {
        int count = 1;
        for (; people.size() > 1; ) {
            Iterator<String> iterator = people.iterator();
            if (count != 1) {
                count = count - people.size();
            }
            while (iterator.hasNext()) {
                if (people.indexOf(iterator.next()) == count) {
                    iterator.remove();
                    count++;
                }
            }
        }
        return people.get(0);
    }

    private static String process(LinkedList<String> people) {
        while (people.size() > 1) {
            for (int i = 0; i < people.size(); i++) {
                if (i % 2 != 0) {
                    people.remove(i);
                }
            }
        }
        return people.get(0);
    }
}
