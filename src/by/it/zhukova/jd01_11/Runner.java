package by.it.zhukova.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        list.add("four");
        
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list);
        list.add(3,"five");
        System.out.println(list);

        List<String> my=new ListA<>();
        my.add("one");
        my.add("two");
        my.add("three");
        my.add("four");

        System.out.println(my);
        System.out.println(my.get(1));
        my.remove(1);
        System.out.println(my);

        List<String> myB =new ListB<>();
        myB.add("one");
        myB.add("two");
        myB.add("three");
        myB.add("four");
        myB.addAll(myB);
        System.out.println(myB);

        HashSet<String> objects = new HashSet<>();
        objects.add ("1");
        objects.add ("Hello");
        objects.add ("Privet");
        objects.add ("Zdraste");
        objects.add ("1");

        System.out.println(objects);

        SetC<String> Str = new SetC<>();
        Str.add ("1");
        Str.add ("Hello");
        Str.add ("Privet");
        Str.add ("Zdraste");
        Str.add ("1");
        System.out.println(Str);


    }
}
