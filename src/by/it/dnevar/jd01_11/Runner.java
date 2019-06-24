package by.it.dnevar.jd01_11;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        Set<String> el = new SetC<>();
        el.add("one");
        el.add("two");
        el.add("three");
        el.add("four");

        System.out.println(el);
        el.remove(1);
        System.out.println(el);
    }
}
