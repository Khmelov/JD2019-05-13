package by.it.tbabich.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List<String> myList = new ListB<>();
        List<String> arrList = new ArrayList<>();

        myList.add("1");
        myList.add("2");
        myList.add("3");

        arrList.add("1");
        arrList.add("2");
        arrList.add("3");

        System.out.println(myList);
        System.out.println(arrList);

        System.out.println(myList.get(1));
        System.out.println(arrList.get(1));

//        myList.remove("2");
//        myList.remove(0);
//        arrList.remove("2");
//        arrList.remove(0);

        System.out.println(myList);
        System.out.println(arrList);

        myList.addAll(arrList);
        System.out.println(myList);

    }
}
