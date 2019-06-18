package by.it.buymistrov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    @SafeVarargs
    private static <E> Set<E> getUnion(Set<E>... n) {
        Set<E> resultSet = null;
        for (int i = 0; i < n.length - 1; i++) {
            resultSet = new HashSet<>(n[i]);
            resultSet.addAll(n[i + 1]);
        }

        return resultSet;
    }

    @SafeVarargs
    private static <E> Set<E> getCross(Set<E>... n) {
        Set<E> resultSet = null;
        for (int i = 0; i < n.length - 1; i++) {
            resultSet = new HashSet<>(n[i]);
            resultSet.retainAll(n[i + 1]);
        }

        return resultSet;
    }


    public static void main(String[] args) {

        HashSet a = new HashSet<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 4, 5, 6, 7, 7, 7));
        HashSet b = new HashSet<>(Arrays.asList(4.3, 1.0, 1.0, 2.0));
        HashSet c = new HashSet<>(Arrays.asList(4.3, 1.0, 2.0));
        HashSet d = new HashSet<>(Arrays.asList(4, 5));
        HashSet e = new HashSet<>(Arrays.asList(7, 8, 8, 9, 9, 9, 9, 9));
        HashSet f = new HashSet<>(Arrays.asList('a', 'r', 'a', 't', 'g'));
        HashSet g = new HashSet<>(Arrays.asList('a', 'g', 'y'));



        System.out.println("union:" + getUnion(e, d, a));
        System.out.println("cross:" + getCross(a, b, c));
        System.out.println("UnionChar" + getUnion(f, g));


    }
}