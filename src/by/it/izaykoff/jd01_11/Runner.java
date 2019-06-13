package by.it.izaykoff.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");

        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list);


        Set<String> myList = new SetC<>();
        myList.add("ten");
        myList.add("twenty");
        myList.add("thirty");
        myList.add("forty");
        myList.add("ten");
        myList.add("twenty");
        myList.add("thirty");
        myList.add("forty");
        myList.add("ten");
        myList.add("twenty");
        myList.add("thirty");
        myList.add("forty");

        myList.addAll(myList);

        System.out.println(myList);
        myList.remove(1);
        System.out.println(myList);

    }
}
