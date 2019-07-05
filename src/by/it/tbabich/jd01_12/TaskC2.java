package by.it.tbabich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {

    public static void main(String[] args) {
        HashSet<Integer> a = new HashSet<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 7));
        HashSet<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 7, 7, 7, 8, 8, 9, 9, 9, 9, 9, 9));
        HashSet<Integer> c = new HashSet<>(Arrays.asList(4, 6, 8, 8, 9, 9, 9, 9, 9, 9, 10));
        Set<Number> union = getUnion(a, b, c);
        Set<Number> cross = getCross(a, b, c);
        System.out.println("union: " + union);
        System.out.println("cross: " + cross);
    }

    private static Set<Number> getCross(Set<? extends Number> ... sets) {
        Set<Number> resultSet = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            resultSet.retainAll(sets[i]);
        }
        return resultSet;
    }

    private static Set<Number> getUnion(Set<? extends Number> ... sets) {
        Set<Number> resultSet = new HashSet<>(sets[0]);
        for (int i = 1; i < sets.length; i++) {
            resultSet.addAll(sets[i]);
        }
        return resultSet;
    }
}
