package by.it.yakovets.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        System.out.println("List после добавления "+list);
        System.out.println("List get "+list.get(1));
        list.remove(1);
        System.out.println("List после удаления "+list);
        list.set(1,"Five");
        System.out.println("List после Set "+list);



        List<String> my = new ListA<>();
        my.add("one");
        my.add("two");
        my.add("three");
        my.add("four");
        System.out.println("MY после добавления "+my);
        System.out.println("MY Get "+my.get(1));
        my.remove(1);
        System.out.println("MY после удаления "+my);


        List<String> my1 = new ListB<>();
        my1.add("one");
        my1.add("two");
        my1.add("three");
        my1.add("four");
        System.out.println("MY1 после добавления "+my1);
        System.out.println("M1 GET "+my1.get(1));
        my1.remove(1);
        System.out.println("MY1 после удаления "+my1);
        my1.set(1,"Five");
        System.out.println("MY после Set "+my1);
        my1.addAll(list);
    }
}
