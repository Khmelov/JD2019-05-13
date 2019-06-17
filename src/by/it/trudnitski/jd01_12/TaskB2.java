package by.it.trudnitski.jd01_12;

import java.util.*;

public class TaskB2 {
    private static Integer[]arr={1, 1, 3, 1, 3, 5, 7, 1, 3, 5, 7, 9, 11, 13, 15, 1};
    private static List<?> arrayList =new ArrayList<>(Arrays.asList(arr));
    private static List<?> linkedList = new LinkedList<>(Arrays.asList(arr));

    static String process(ArrayList<String> peoples) {
        Iterator<String> iterator = peoples.iterator();
        if (peoples.size() == 1) return peoples.toString();
            while (peoples.size() > 1) {
                while (iterator.hasNext()) {
                    iterator.next();
                    if (iterator.hasNext()) {
                        iterator.remove();
                    }
                }
            }
        return peoples.toString();
    }



        static String process (LinkedList < String > peoples) {
            Iterator<String> iterator = peoples.iterator();
            if (peoples.size() == 1) return peoples.toString();
            while (peoples.size() > 1) {
                while (iterator.hasNext()) {
                    iterator.next();
                    if (iterator.hasNext()) {
                        iterator.remove();
                    }
                }
            }
            return peoples.toString();
        }


        public static void main (String[]args){

            System.out.println(arrayList);
            System.out.println(process((ArrayList<String>) arrayList));
        }

    }

