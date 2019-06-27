package by.it.yaskevich.jd01_12;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class TaskC2 {
    public static void main(String[] args) {

        Set<Integer> a = new HashSet<>(Arrays.asList(1, 1, 2, 2, 3, 3, 4, 5, 6, 7, 7, 7));
        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 7, 7, 8, 8, 9, 9, 9, 9, 9, 9));
        Set<Integer> c = new HashSet<>(Arrays.asList(5, 5, 8, 10, 11, 4, 13, 16, 24, 25));

        Set union = getUnion(a, b, c);
        Set cross = getCross(a, b, c);
        System.out.println("union: " + union);
        System.out.println("cross: " + cross);

        Set<Short> d = new HashSet<>(Arrays.asList((short)1, (short)2, (short)3, (short)4, (short)5));
        Set<Short> e = new HashSet<>(Arrays.asList((short)-1, (short)2, (short)7, (short)4, (short)8));

        union = getUnion(d, e);
        cross = getCross(d, e);
        System.out.println("union: " + union);
        System.out.println("cross: " + cross);

    }

    @SafeVarargs
    private static <T extends Number> Set<T> getCross(Set<? extends T> ... args) {
        if (args.length == 1) {
            return new HashSet<>(args[0]);
        } else if (args.length > 1) {
            HashSet<T> resultSet = new HashSet<>(args[0]);
            for (int i = 1; i < args.length; i++) {
                resultSet.retainAll(args[i]);
            }
            return resultSet;
        }
        return null;
    }

    @SafeVarargs
    private static <T extends Number> Set<T> getUnion(Set<? extends T> ... args) {
        if (args.length == 1) {
            return new HashSet<>(args[0]);
        } else if (args.length > 1) {
            HashSet<T> resultSet = new HashSet<>();
            for (Set<? extends Number> arg : args) {
                resultSet.addAll((Collection<? extends T>) arg);
            }
            return resultSet;
        }
        return null;
    }

}
