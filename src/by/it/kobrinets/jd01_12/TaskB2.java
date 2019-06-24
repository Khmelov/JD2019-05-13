package by.it.kobrinets.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {
        String[] peoples = {"Nina", "Vlad", "Den", "Masha", "Oleg", "Gleb", "Ivan", "Dasha"};

        ArrayList<String> arrList = new ArrayList<>(Arrays.asList(peoples));
        LinkedList<String> linkList = new LinkedList<>(Arrays.asList(peoples));

        System.out.println(process(arrList));
        System.out.println(process(linkList));

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
}