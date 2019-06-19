package by.it.aadamovich.jd01_12;

import java.util.*;

public class TaskA2 {

    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>();
        TaskA2.fillList(a);

        Set<Integer> b = new TreeSet<>(Arrays.asList(3, 3, 3, 4, 5, 5, 6, 7, 8, 8, 8, 9, 9, 10, 11));

        System.out.println("Hashset: " + a);
        System.out.println("Treeset: " + b);
        System.out.println("Union: " + getUnion(a, b));
        System.out.println("My Union: " + myGetUnion(a, b));
        System.out.println("Cross: " + getCross(a, b));
        System.out.println("My Cross: " + myGetCross(a, b));
    }

    private static void fillList(Set<Integer> set) {
        for (int i = 0; i < 15; i++) set.add((int) (Math.random() * 10) + 1);
    }

    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    // without using addAll method
    private static Set<Integer> myGetUnion(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        for (Integer next : two) if (!result.contains(next)) result.add(next);
        return result;
    }

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two) {
        Set<Integer> result = new HashSet<>(one);
        result.retainAll(two);
        return result;
    }

    // without using retainAll method
    private static Set<Integer> myGetCross(Set<Integer> one, Set<Integer> two) {

        Set<Integer> result = new HashSet<>();
        for (Integer next : one) if (two.contains(next)) result.add(next);
        return result;
    }
}
