package by.it.aadamovich.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {

        ArrayList<String> arrayPeople = new ArrayList<>();
        fillList(arrayPeople);
        LinkedList<String> linkedPeople = new LinkedList<>(arrayPeople);

        System.out.println("ArrayList: " + arrayPeople);
        System.out.println("Last to survive Array: " + process(arrayPeople));
        System.out.println("LinkedList: " + linkedPeople);
        System.out.println("Last to survive Linked: " + process(linkedPeople));
    }

    private static void fillList(List<String> list) {
        for (int i = 0; i < 15; i++) list.add("N" + ((int) (Math.random() * 20) + 1));
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
}