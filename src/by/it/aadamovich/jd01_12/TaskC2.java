package by.it.aadamovich.jd01_12;

import java.util.*;

public class TaskC2 {


    public static void main(String[] args) {

        Set<Integer> a = new TreeSet<>(Arrays.asList(3, 3, 3, 4, 5, 5, 6, 7, 8, 8, 8, 9, 9, 10, 11));
        Set<Integer> b = new HashSet<>(Arrays.asList(1, 4, 5, 10, 11));

        Set<Double> c = new HashSet<>(Arrays.asList(1.0, 4.0, 6.0, 9.0, 11.0));
        Set<Double> d = new HashSet<>(Arrays.asList(1.0, 2.0, 4.0, 3.0, 5.0, 6.0, 9.0));

        System.out.println("Set a: " + a);
        System.out.println("Set b: " + b);
        System.out.println("Set c: " + c);
        System.out.println("Set d: " + d);

        System.out.printf("Union of sets: %s%n", getUnion(a, b, c, d));
        System.out.printf("Cross of sets: %s%n", getCross(a, b, c, d));

    }

     private static Set<Double> getUnion(Set<? extends Number>... V) {
        Set<Double> result = new TreeSet<>();
        for (Set<? extends Number> set : V) {
            for (Number number : set) {
                result.add(number.doubleValue());
            }
        }
        return result;
    }

    @SafeVarargs
    private static Set<Number> getCross(Set<? extends Number>... V) {

        Set<Number> result = new HashSet<>();

        for (Number number : V[0]) { // Checking each element of the first set
            int count = 1;           // Counts how many sets contain element (including first set)
            for (int i = 1; i < V.length; i++) {
                if (count < i) break;    // False means that at least one set doesn't contain this element

                for (Number value : V[i]) {       //  Checking current element of the first set to contain in all other sets
                    if (value.doubleValue() == number.doubleValue()) {
                        count++;
                        break;
                    }
                }
            }
            if (count == V.length) result.add(number.doubleValue()); // Adding only if the element is included in all sets
        }
        return result;
    }
}


