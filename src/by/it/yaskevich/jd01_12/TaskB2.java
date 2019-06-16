package by.it.yaskevich.jd01_12;

import java.util.*;

public class TaskB2 {
    private static String process(ArrayList<String> peoples) {
        return processList(new ArrayList<>(peoples));
    }

    private static String process(LinkedList<String> peoples) {
        return processList(new LinkedList<>(peoples));
    }

    private static String processList(List<String> peoplesCopy) {
        boolean nextSecond = false;
        while (peoplesCopy.size() > 1) {
            Iterator<String> iterator = peoplesCopy.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (nextSecond == true) {
                    iterator.remove();
                }
                nextSecond = !nextSecond;
            }
        }
        return peoplesCopy.get(0);
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>(10);
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i <= 10; i++) {
            arrayList.add("n" + i);
            linkedList.add("n" + i);
        }

        System.out.println(process(arrayList));
        System.out.println(process(linkedList));
    }
}
