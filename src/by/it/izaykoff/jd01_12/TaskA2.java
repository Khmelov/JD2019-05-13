package by.it.izaykoff.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class TaskA2 {

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,2,3,3,42,4,5,6,7,6,5,7,8));
        Set<Integer> b = new HashSet<>(Arrays.asList(4,32,7,6,5,7,8,9,6,8,4,1,5,8,9,6));
        System.out.println("a: " + a);
        System.out.println("b: " + b);
        Set<Integer> union = getUnion(a, b);
        Set<Integer> cross = getCross(a, b);
        System.out.println("union:" + union);
        System.out.println("cross:" + cross);

    }

    private static Set<Integer> getUnion(Set<Integer> first, Set<Integer> second){
        Set<Integer> resultSet = new HashSet<>(first);
        resultSet.addAll(second);
        return resultSet;
    }

    private static Set<Integer> getCross(Set<Integer> first, Set<Integer> second){
        Set<Integer> resultSet = new HashSet<>(first);
        resultSet.retainAll(second);
        return resultSet;
    }

}
