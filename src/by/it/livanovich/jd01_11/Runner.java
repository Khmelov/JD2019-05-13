package by.it.livanovich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List <String> list=new ArrayList<>();
        list.add ("one");
        list.add ("two");
        list.add ("three");
        list.add ("four");
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.get(2));
        list.set(2,"five");
        System.out.println(list);
        list.add(0,"zero");
        System.out.println(list);
        list.addAll(list);
        System.out.println(list);
        ListB <String> myList=new ListB <>();
        myList.add ("one");
        myList.add ("two");
        myList.add ("three");
        myList.add ("four");
        myList.add("six");
        System.out.println(myList);
        System.out.println(myList.remove(1));
        System.out.println(myList);
        System.out.println(myList.get(2));
        myList.set(2,"five");
        System.out.println(myList);
        myList.add(0,"zero");
        System.out.println(myList);
        myList.addAll(myList);
        System.out.println(myList);
        Set <Integer> set=new HashSet<>();
        set.add(1); set.add(2); set.add(7); set.add(4); set.add(5);
        System.out.println(set);
        set.remove(2);
        System.out.println(set);
        System.out.println(set.contains(7));
        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.addAll(set));
        System.out.println(set.containsAll(set));
        System.out.println(set.removeAll(set));
        System.out.println(set);
        Set <Integer> mySet=new SetC<>();
        mySet.add(1); mySet.add(2); mySet.add(7); mySet.add(4); mySet.add(5);
        System.out.println(mySet);
        mySet.remove(2);
        System.out.println(mySet);
        System.out.println(mySet.contains(7));
        System.out.println(mySet.size());
        System.out.println(mySet.isEmpty());
        System.out.println(mySet.addAll(mySet));
        System.out.println(mySet.containsAll(mySet));
        System.out.println(mySet.removeAll(mySet));
        System.out.println(mySet);
    }
}
