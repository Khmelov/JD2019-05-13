package by.it.trudnitski.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String>list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("tree");
        list.add("four");
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list);


        List<String>my=new ArrayList<>();
        my.add("one");
        my.add("two");
        my.add("tree");
        my.add("four");
        System.out.println(my);
        System.out.println(my.get(1));
        my.remove(1);
        System.out.println(my);
        System.out.println();

        List<String>myList=new ArrayList<>();
        myList.add("one");
        myList.add("two");
        myList.add("tree");
        myList.add("four");
        myList.add("five");
        System.out.println(myList);
        System.out.println(myList.get(2));
        myList.remove(2);
        myList.set(3, "forewer");
        System.out.println(myList);
        System.out.println();


        Set<String> set=new HashSet<>();
        set.add("Hello");
        set.add("My name is Tim");
        set.add("Where are you from");
        set.add("Minsk");
        set.add("capital");
        set.add("Belarus");
        System.out.println(set);
        set.remove("capital");
        System.out.println(set);
        if(set.contains("Minsk")) System.out.println("set contains Minsk");
        System.out.println(set.size());
        set.addAll(myList);
        System.out.println(set);




    }
}
