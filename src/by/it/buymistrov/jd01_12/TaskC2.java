package by.it.buymistrov.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    @SafeVarargs
    private static <E> Set<E> getUnion(Set<E>... n) {
        HashSet<E> resultSet = new HashSet<>();
        for (Set<E> uN : n) {
            resultSet.addAll(uN);
        }
        return resultSet;
    }

    @SafeVarargs
    private static <E> Set<E> getCross(Set<E>... n) {
        HashSet<E> resultSet = new HashSet<>(n[0]);
            for (int i = 1; i < n.length; i++) {
                resultSet.retainAll(n[i]);
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
        System.out.println("cross:" + getCross( b, c));
        System.out.println("UnionChar" + getUnion(f, g));


    }
}