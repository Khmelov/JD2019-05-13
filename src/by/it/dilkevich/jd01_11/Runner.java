package by.it.dilkevich.jd01_11;

import java.util.*;
import java.util.List;

public class Runner {

    public static void main(String[] args) {


        Set<Short> a=new SetC<>();

        Set<Short> e = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            e.add((short) (i * 2));
            a.add((short) (i * 2));
        }
        System.out.println(a);
        System.out.println(e);

        List<Short> added = new ArrayList<>();
        added.add(null);
        added.add(null);
        added.add((short) 1000);
        added.add((short) 1000);
        added.add((short) 1001);
        added.add((short) 1002);
        e.addAll(added);
        a.addAll(added);

        System.out.println(a);
        System.out.println(e);

        System.out.println(a.removeAll(added));
        System.out.println(e.removeAll(added));

        System.out.println(a);
        System.out.println(e);

    }
}
