package by.it.aadamovich.jd01_12;

import java.util.*;

public class TaskB3 {

    public static void main(String[] args) {

        ArrayList<String> arrayPeople = new ArrayList<>();
        fillList(arrayPeople);
        LinkedList<String> linkedPeople = new LinkedList<>(arrayPeople);
        LinkedList<String> linkedPeople2 = new LinkedList<>(arrayPeople);


        System.out.println("ArrayList: " + arrayPeople);

        Timer timer = new Timer();

        System.out.println("Last to survive Array: " + process(arrayPeople) + timer);
        System.out.println("Last to survive Linked: " + process(linkedPeople) + timer);
        System.out.println("Last to survive MyLinked: " + processNoIterator(linkedPeople2) + timer);
    }

    private static void fillList(List<String> list) {
        for (int i = 0; i < 4096; i++) list.add("N" + ((int) (Math.random() * 20) + 1));
    }

    private static int count = 0;

    private static String process(ArrayList<String> peoples) {

        Iterator<String> iterator = peoples.iterator();
        while (peoples.size() > 1) {
            if (!iterator.hasNext()) {
                process(peoples);
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

        ListIterator<String> iterator = peoples.listIterator();
        while (peoples.size() > 1) {
            if (!iterator.hasNext()) {
                process(peoples);
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

    private static String processNoIterator(LinkedList<String> peoples) {

        count = 1;

        while (peoples.size() > 1) {
            if (count > peoples.size()) {
                count = 1;
                processNoIterator(peoples);
            } else if (count == peoples.size()) {
                                count=0;
                processNoIterator(peoples);
            } else {
                peoples.remove(count);
                count++;
            }
        }
        count = 0;
        return peoples.get(0);
    }

    public static class Timer {
        private long startTime;
        private double workTime;

        Timer() {
            startTime = System.nanoTime();
        }

        @Override
        public String toString() {
            workTime = (double) ((System.nanoTime() - startTime) / 1000);
            startTime = System.nanoTime();
            return " Время работы: " + workTime + " микросекунд";
        }
    }
}
