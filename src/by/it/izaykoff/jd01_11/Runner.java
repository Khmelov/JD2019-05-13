package by.it.izaykoff.jd01_11;

import java.util.ArrayList;
import java.util.List;

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

        List<String> myList = new ListB<>();
        myList.add("ten");
        myList.add("twenty");
        myList.add("thirty");
        myList.add("forty");
        myList.set(0,"zero");

        System.out.println(myList);
        System.out.println(myList.get(1));
        myList.remove(1);
        System.out.println(myList);

    }
}
