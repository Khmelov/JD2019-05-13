package by.it.yaskevich.jd01_12;

import java.util.*;

public class TaskB3 {
    private static String process(ArrayList<String> peoples) {
        return processList(new ArrayList<>(peoples));
    }

    private static String process(LinkedList<String> peoples) {
        return processList(new LinkedList<>(peoples));

        // это второй способ, на интерфйсе очереди
        //return processList2(new LinkedList<>(peoples));
    }

    private static String processList2(Queue<String> peoples) {
        LinkedList<String> peoplesCopy = new LinkedList<>(peoples);
        while (peoplesCopy.size() > 1) {
            peoplesCopy.offer(peoplesCopy.poll());
            peoplesCopy.poll();
        }
        return peoplesCopy.get(0);
    }

    private static String processList(List<String> peoplesCopy) {
        boolean nextSecond = false;
        while (peoplesCopy.size() > 1) {
            Iterator<String> iterator = peoplesCopy.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (nextSecond) {
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
        for (int i = 1; i <= 4096; i++) {
            arrayList.add("n" + i);
            linkedList.add("n" + i);
        }

        long time = System.nanoTime();
        System.out.println(process(arrayList));
        System.out.printf("ArrayList: %d мкс.\n", (System.nanoTime() - time) / 1000);
        time = System.nanoTime();
        System.out.println(process(linkedList));
        System.out.printf("LinkedList: %d мкс.\n", (System.nanoTime() - time) / 1000);
    }
}
