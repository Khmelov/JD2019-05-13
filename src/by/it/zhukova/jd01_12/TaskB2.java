package by.it.zhukova.jd01_12;

import java.util.*;

public class TaskB2 {
   private static   ArrayList<String> people1 = new ArrayList<String>() ;
    private static LinkedList<String> people2 = new LinkedList<String>();
    public static void main(String[] args) {
        people1.add("Ваня");
        people1.add("Петя");
        people1.add("Аня");
        people1.add("Вера");
        people1.add("Саша");
        people1.add("Ира");
        people1.add("Леша");
        people1.add("Марина");
        people1.add("Лена");

        people2.add("Ваня");
        people2.add("Петя");
        people2.add("Аня");
        people2.add("Вера");
        people2.add("Саша");
        people2.add("Ира");
        people2.add("Леша");
        people2.add("Марина");
        people2.add("Лена");

        String winner1 = process(people1);
        String winner2 = process(people2);
        System.out.println(winner1);
        System.out.println(winner2);
    }
    static String process (ArrayList<String> peoples){
        boolean even = true;
        int position;
        while (peoples.size()>1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                String name = iterator.next();
                if (even) even=false;
                   else {
                       iterator.remove();
                       even=true;
                   }
            }
        }
        String winner=peoples.get(0);
        return winner;
       }
     static String process (LinkedList<String> peoples) {
         boolean even = true;
         int position;
         while (peoples.size()>1) {
             Iterator<String> iterator = peoples.iterator();
             while (iterator.hasNext()) {
                 String name = iterator.next();
                 if (even) even=false;
                 else {
                     iterator.remove();
                     even=true;
                 }
             }
         }
         String winner=peoples.get(0);
         return winner;
     }
    }
