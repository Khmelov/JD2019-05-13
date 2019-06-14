package by.it.buymistrov.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
//        List<String> list = new ArrayList<>();
//        list.add("one");
//        list.add("two");
//        list.add("three");
//        System.out.println(list);
//        System.out.println(list.get(1));
//        list.remove(1);
//        System.out.println(list);
//        list.set(1, "ew");
//
//        System.out.println(list);
//
//
//        System.out.println();
//        List<String> my = new ListA<>();
//
//        my.add("one");
//        my.add("two");
//        my.add("three");
//        System.out.println(my);
//        System.out.println(my.get(1));
//        my.remove(1);
//        System.out.println(my);

        Set<Short> e = new HashSet<>();


        SetC<Short> qqq = new SetC<>();
        SetC<Short> qqqq = new SetC<>();

        qqqq.add((short) 2);
        qqqq.add((short) 4);
        qqqq.add((short) 6);

        for (int i = 0; i < 10; i++) {
            qqq.add((short) (i * 2));
            e.add((short) (i * 2));
        }

//        for (Short aShort : e) {
//            System.out.println(aShort + " " + aShort.hashCode());
//        }

//
//
//
//        System.out.println(qqq);
//
//        System.out.println(qqq.size());

        System.out.println();
        System.out.println();
        System.out.println(qqq);
        System.out.println(qqqq);

        qqq.removeAll(qqqq);
        System.out.println(qqq);


    }
}
