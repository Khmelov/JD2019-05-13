package by.it.maniuk.jd01_11;

import java.util.*;

public class Runner {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("one"); list.add("two"); list.add("three"); list.add("four");
//        System.out.println(list);
//        System.out.println(list.get(1));
//        list.remove(1);
//        System.out.println(list);
//
//
//        List<String> my = new ListA<>();
//
//      my.add("one"); my.add("two"); my.add("three"); my.add("four");
//        System.out.println(my);
//        System.out.println(my.get(1));
//        my.remove(1);
//        System.out.println(my);
//
//        List<String> strings = new ListB<>();
//
//        strings.add("one"); strings.add("two"); strings.add("three"); strings.add("four");
//        System.out.println(strings);
//        System.out.println(strings.get(1));
//        strings.remove(1);
//        System.out.println(strings);
//        strings.set(1, "bugaga");
//        System.out.println(strings);
//        strings.add(1, "gagabu");
//        System.out.println(strings);
//
//        strings.addAll(strings);
//        System.out.println(strings);

        Set<String> set = new HashSet<>();

        set.add("1");
        set.add("3");
        set.add("5");
        set.add("9");
        System.out.println(set);

        Set<Integer> mySet = new SetC<>();
        mySet.add(2);
        mySet.add(3);
        mySet.add(4);
        mySet.add(5);
        System.out.println(mySet);

    }
}
