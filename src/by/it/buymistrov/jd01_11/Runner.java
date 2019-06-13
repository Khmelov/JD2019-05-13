package by.it.buymistrov.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("one");
        list.add("two");
        list.add("three");
        System.out.println(list);
        System.out.println(list.get(1));
        list.remove(1);
        System.out.println(list);

        List<String> my = new ListA<>();

        my.add("one");
        my.add("two");
        my.add("three");
        System.out.println(my);
        System.out.println(my.get(1));
        my.remove(1);
        System.out.println(my);



    }
}
