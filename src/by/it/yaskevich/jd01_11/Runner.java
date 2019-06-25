package by.it.yaskevich.jd01_11;

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

        List<String> my = new ListA<>();
        my.add("one");
        my.add("two");
        my.add("three");
        my.add("four");
        System.out.println(my);
        System.out.println(my.get(1));
        my.remove(1);
        System.out.println(my);

        Set<Short> set = new HashSet<Short>(){
            {
                add((short) 1);
                add((short) 2);
                add((short) 3);
                add((short) 1);
            }
        };
        System.out.println(set.toString());
        set.remove(2);
        System.out.println(set.toString());

        Set<Short> set2 = new SetC<Short>(){
            {
                add((short) 1);
                add((short) 2);
                add((short) 3);
                add((short) 1);
            }
        };
        System.out.println(set2.toString());
        set2.remove(2);
        System.out.println(set2.toString());
    }
}
