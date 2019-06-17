package by.it.izaykoff.jd01_12;

import java.util.*;

public class TaskB2 {
    public static void main(String[] args) {

        String[] testPeople = {"one","two","three","four","five","six"};
        String[] testPeople2 = {"one","two","three","four","five","six","seven"};

        ArrayList<String> peoplesArrayList = new ArrayList<>(Arrays.asList(testPeople));
        LinkedList<String> peoplesLinkedList = new LinkedList<>(Arrays.asList(testPeople2));

        System.out.println(process(peoplesArrayList));
        System.out.println(process(peoplesLinkedList));


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

    static String process(LinkedList<String> peoples) {
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



}
