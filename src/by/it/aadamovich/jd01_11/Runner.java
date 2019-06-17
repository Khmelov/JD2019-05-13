package by.it.aadamovich.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Runner {

    public static void main(String[] args) {

        HashSet<Object> hashset = new HashSet<>();
        SetC<String> myHashset = new SetC<>();
        List<String> toAdd = new ArrayList<String>() {
            {
                this.add("add1");
                this.add("add2");
            }
        };

        hashset.add("one");
        myHashset.add("one");
        hashset.add("two");
        myHashset.add("two");
        hashset.add("three");
        myHashset.add("three");
        hashset.add("three");
        myHashset.add("three");
        System.out.println("add HashSet: " + hashset + "\nMyHashSet: " + myHashset);
        hashset.addAll(toAdd);
        myHashset.addAll(toAdd);
        System.out.println("addAll HashSet: " + hashset + "\nMyHashSet: " + myHashset);

        hashset.remove("two");
        myHashset.remove("two");
        hashset.remove("add2");
        myHashset.remove("add2");
        System.out.println("remove HashSet: " + hashset + "\nMyHashSet: " + myHashset);

        System.out.println("contains two: " + hashset.contains("two") + " (M): " + myHashset.contains("two"));
        System.out.println("contains add2(H): " + hashset.contains("three") + " (M): " + myHashset.contains("three"));

        System.out.println("size (H): " + hashset.size() + " (M): " + myHashset.size());
        System.out.println("isEmpty (H): " + hashset.isEmpty() + " (M): " + myHashset.isEmpty());

        System.out.println("containsAll: " + hashset.containsAll(toAdd) + " (M): " + myHashset.containsAll(toAdd));
        System.out.println("removeAll: " + hashset.removeAll(toAdd) + " (M): " + myHashset.removeAll(toAdd));

        System.out.println("HashSet: " + hashset + "\nMyHashSet: " + myHashset);
    }
}
