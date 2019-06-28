package by.it.trudnitski.jd01_12;

import java.util.*;

public class TaskB2 {
//    private static Integer[]arr={1, 1, 3, 1, 3, 5, 7, 1, 3, 5, 7, 9, 11, 13, 15, 1};
//    private static List<?> arrayList =new ArrayList<>(Arrays.asList(arr));
//    private static List<?> linkedList = new LinkedList<>(Arrays.asList(arr));


    static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
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
        }
        return peoples.get(0);
    }



        static String process (LinkedList < String > peoples) {
            int count = 1;
            while (peoples.size() > 1) {
                Iterator<String> iterator = peoples.iterator();
                while (iterator.hasNext()) {
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
            }
            return peoples.get(0);
        }


        public static void main (String[]args){

            ArrayList<String> arrayList = new ArrayList<>(10);
            LinkedList<String> linkedList = new LinkedList<>();
            for (int i = 1; i <= 10; i++) {
                arrayList.add("n" + i);
                linkedList.add("n" + i);
            }

            System.out.println(arrayList);
            System.out.println(process(arrayList));
            System.out.println(process(linkedList));
        }

    }


