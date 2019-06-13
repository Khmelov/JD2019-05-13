package by.it.adamovichjr.jd01_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ListA<Integer> myList = new ListA<>();
        List<Integer> javaList = new ArrayList<>();
        //Test
        myList.add(1);
        javaList.add(1);
        myList.add(2);
        javaList.add(2);
        myList.add(3);
        javaList.add(3);
        System.out.println("myList add " + myList);
        System.out.println("javaList add " + javaList);
        System.out.println();

        System.out.println("myList.get(2) " + myList.get(2));
        System.out.println("javaList.get(2) " + javaList.get(2));
        System.out.println();

        System.out.println("myList.remove(0) " + myList.remove(0));
        System.out.println("javaList.remove(0) " + javaList.remove(0));
        System.out.println("myList " + myList);
        System.out.println("javaList " + javaList);
        System.out.println();
        System.out.println("TaskB");
        System.out.println();

        ListB<Integer> myListB = new ListB<>();
        List<Integer> listB = new ArrayList<>();
        myListB.add(7);
        myListB.add(8);
        myListB.add(9);
        listB.add(7);
        listB.add(8);
        listB.add(9);
        System.out.println("myListB.add " + myListB);
        System.out.println("listB.add " + listB);
        System.out.println();


        System.out.println("myListB.set(0,10) " + myListB.set(0,10));
        System.out.println("listB.set(0,10) " + listB.set(0,10));
        System.out.println();

        myListB.add(0,11);
        listB.add(0,11);
        System.out.println("myListB.add(0,11) " + myListB);
        System.out.println("listB.add(0,11) " + listB);
        System.out.println();

        Integer[]b ={1, 2, 3};
        System.out.println("b = {1, 2, 3}");
        myListB.addAll(Arrays.asList(b));
        listB.addAll(Arrays.asList(b));
        System.out.println("myListB.addAll(Arrays.asList(b)) " + myListB);
        System.out.println("listB.addAll(Arrays.asList(b)) " + listB);
        System.out.println();


        System.out.println("TaskC");
        System.out.println();

        HashSet<Integer> javaHas = new HashSet<>();
        SetC<Integer> myHash = new SetC<>();
        javaHas.add(1);
        myHash.add(1);
        javaHas.add(2);
        myHash.add(2);
        javaHas.add(3);
        myHash.add(3);
        javaHas.add(4);
        myHash.add(4);
        System.out.println("javaHas.add " + javaHas);
        System.out.println("myHash.add " + myHash);
        System.out.println();

        System.out.println("javaHas.contains(2) " + javaHas.contains(2));
        System.out.println("myHash.contains(2) " + myHash.contains(2));
        System.out.println();

        System.out.println("javaHas.remove(2) " + javaHas.remove(2));
        System.out.println("myHash.remove(2) " + myHash.remove(2));
        System.out.println("javaHas " + javaHas);
        System.out.println("myHash " + myHash);
        System.out.println();

        System.out.println("javaHas.size() " + javaHas.size());
        System.out.println("myHash.size() " + myHash.size());
        System.out.println();


        Integer[] c = {1,5};
        javaHas.removeAll(Arrays.asList(c));
        myHash.removeAll(Arrays.asList(c));
        System.out.println("Integer[] c = {1,5} ");
        System.out.println("javaHas.removeAll(Arrays.asList(c)) " + javaHas);
        System.out.println("myHash.removeAll(Arrays.asList(c)) " + myHash);

        /*Integer[] b2 = {10,2,3,25,17};
        System.out.println("Integer[] b2 = {10,2,3,25,17}");
        javaHas.addAll(Arrays.asList(b2));
        System.out.println(javaHas);
        for (Integer ha : javaHas) {
            System.out.println(ha.hashCode());
        }
        javaHas.equals(myList);*/
    }
}
