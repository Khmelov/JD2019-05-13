package by.it.tbabich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListB<>();
        List<String> arrList = new ArrayList<>();
        List<Long> longList = new ListB<>();
        Set<String> strings = new HashSet<>();

        myList.add("1");
        myList.add("2");
        myList.add("3");

        arrList.add("4");
        arrList.add("5");
        arrList.add("6");

        System.out.println(myList);
        System.out.println(arrList);

        System.out.println(myList.get(1));
        System.out.println(arrList.get(1));

//        myList.remove("2");
//        myList.remove(0);
//        arrList.remove("2");
//        arrList.remove(0);

        System.out.println(myList);
        System.out.println(arrList);

        myList.addAll(1, arrList);
        System.out.println(myList);
        System.out.println(myList.indexOf(444));
        longList.add(1L);
        longList.add(2L);
        System.out.println(longList.indexOf(2L));
    }
}
