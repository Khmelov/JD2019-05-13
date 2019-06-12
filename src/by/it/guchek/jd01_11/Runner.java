package by.it.guchek.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List <String> list = new ArrayList<>(); //настоящий
        list.add("one");list.add("two");list.add("three");
        System.out.println(list);
        System.out.println(list.get(1));

    }

}
