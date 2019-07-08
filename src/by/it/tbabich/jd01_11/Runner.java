package by.it.tbabich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<String> myListA = new ListA<>();
        List<String> myListB = new ListB<>();
        List<String> arrList = new ArrayList<>();
        Set<String> strings = new HashSet<>();
        Set<String> myStringsC = new SetC<>();

        myListA.add("1");
        myListA.add("2");
        myListA.add("3");
        myListB.add("1");
        myListB.add("2");
        myListB.add("3");

        arrList.add("4");
        arrList.add("5");
        arrList.add("6");

        System.out.println(myListA.get(1));
        System.out.println(arrList.get(1));

        myListA.remove("2");
        myListB.remove(0);
        arrList.remove("2");

        myListB.addAll(1, arrList);
        System.out.println(myListA);
        System.out.println(myListB);
        System.out.println(arrList);

        strings.add("1");
        strings.add("2");
        myStringsC.add("1");
        myStringsC.add("2");
        strings.remove("1");
        myStringsC.remove("1");
        System.out.println(strings);
        System.out.println(myStringsC);
    }
}
