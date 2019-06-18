package by.it.aadamovich.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {

        ArrayList<String> arrayPeople = new ArrayList<>();
                fillList(arrayPeople);
        ArrayList<String> arrayPeople2 = new ArrayList<>(arrayPeople);

        LinkedList<String> linkedPeople = new LinkedList<>(arrayPeople);
        LinkedList<String> linkedPeople2 = new LinkedList<>(arrayPeople);
        LinkedList<String> linkedPeople3 = new LinkedList<>(arrayPeople);


        long timer = System.nanoTime();
        System.out.printf("Last Array: %s, Время: %d микросекунд%n", process(arrayPeople), (System.nanoTime() - timer) / 1000);

        timer = System.nanoTime();
        System.out.printf("Last ArrayRecursion: %s, Время: %d микросекунд%n", processRecursion(arrayPeople2), (System.nanoTime() - timer) / 1000);

        timer = System.nanoTime();
        System.out.printf("Last Linked: %s, Время: %d микросекунд%n", process(linkedPeople), (System.nanoTime() - timer) / 1000);

        timer = System.nanoTime();
        System.out.printf("Last My Linked: %s, Время: %d микросекунд%n", processNoIterator(linkedPeople2), (System.nanoTime() - timer) / 1000);
    }

    private static void fillList(List<String> list) {
        for (int i = 0; i < 4096; i++) list.add("N" + ((int) (Math.random() * 20) + 1));
    }

    private static int count = 0;

    private static String process(ArrayList<String> peoples) {

        boolean nextSecond = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (nextSecond) {
                    iterator.remove();
                }
                nextSecond = !nextSecond;
            }
        }
        return peoples.get(0);
    }

    private static String processRecursion(List<String> peoples) {

        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() > 1) {
            if (!iterator.hasNext()) {
                processRecursion(peoples);
            } else if (count == 0) {
                iterator.next();
                count++;
            } else {
                iterator.next();
                iterator.remove();
                count--;
            }
        }
        count = 0;
        return peoples.get(0);
    }

    private static String process(LinkedList<String> peoples) {

        boolean nextSecond = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (nextSecond) {
                    iterator.remove();
                }
                nextSecond = !nextSecond;
            }
        }
        return peoples.get(0);
    }

    private static String processNoIterator(List<String> peoples) {
        LinkedList<String> peoplesCopy = new LinkedList<>(peoples);
        while (peoplesCopy.size() > 1) {
            peoplesCopy.offer(peoplesCopy.poll());
            peoplesCopy.poll();
        }
        return peoplesCopy.get(0);
    }
}
