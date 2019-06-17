package by.it.guchek.jd01_12;

import java.util.*;

public class TaskB2 {
    static ArrayList<String> listArr = new ArrayList<>();
    static LinkedList<String> listLink = new LinkedList<>();

    static String process(ArrayList<String> peoples) {
        boolean second = false;

        while (peoples.size() > 1) {
            for (int i = 0; i < peoples.size(); i++) {
                if (second) {
                    peoples.remove(i);
                    System.out.println(peoples);
                    second = false;
                    --i;
                } else {
                    second = true;
                }
            }
        }

        return peoples.get(0);
    }

    ;

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

    ;

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

    }
}
