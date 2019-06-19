package by.it.guchek.jd01_12;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class TaskB3 {
    static ArrayList<String> listArr = new ArrayList<>();
    static LinkedList<String> listLink = new LinkedList<>();

    static String process(ArrayList<String> peoples) {
        boolean second = false;

        while (peoples.size() > 1) {
            for (int i = 0; i < peoples.size(); i++) {
                if (second) {
                    peoples.remove(i);
                    // System.out.println(peoples);
                    second = false;
                    --i;
                } else {
                    second = true;
                }
            }
        }

        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        boolean second = false;

        while (peoples.size() > 1) {
            ListIterator<String> strListIt = peoples.listIterator();

            while (strListIt.hasNext()) {
                strListIt.next();
                if (second) {
                    strListIt.remove();
                    second = false;
                } else {
                    second = true;
                }
            }
        }

        return peoples.get(0);
    }

    static String processFast(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            String first = peoples.pop();
            String second = peoples.pop();
            // Кладем second', добавляем 'first' в конец листа
            peoples.add(first);
            // System.out.println(peoples);
        }

        boolean second = false;

        while (peoples.size() > 1) {
            ListIterator<String> strListIt = peoples.listIterator();

            while (strListIt.hasNext()) {
                strListIt.next();
                if (second) {
                    strListIt.remove();
                    second = false;
                } else {
                    second = true;
                }
            }
        }

        return peoples.get(0);
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Scanner scan1 = new Scanner(System.in);
        Integer countPeople = scan.nextInt();

        String stroke;

        for (Integer i = 0; i < (int) (countPeople); i++) {

            stroke = scan1.nextLine();
            listArr.add(stroke);
            listLink.add(stroke);
        }

        LinkedList<String> listLinkCopy = new LinkedList<>(listLink);

        long startTime = System.currentTimeMillis();
        process(listArr);
        long endTime = System.currentTimeMillis();
        System.out.println("Finished process(ArrayList) in " + (endTime - startTime) + "ms");

        startTime = System.currentTimeMillis();
        process(listLink);
        endTime = System.currentTimeMillis();
        System.out.println("Finished process(LinkedList) in " + (endTime - startTime) + "ms");

        System.out.println("Run processFast(LinkedList)");
        processFast(listLinkCopy);
    }
}
