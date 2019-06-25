package by.it.yakimovich.jd01_12;

import java.util.*;

public class TaskA2 {
    private static Set<Integer> getCross(Set<Integer>first,Set<Integer>second){
        Set<Integer> resultSet=new HashSet<>(first);
        resultSet.retainAll(second);
        return resultSet;
    }
    private static Set<Integer> getUnion(Set<Integer>first,Set<Integer>second){
        Set<Integer> resultSet=new HashSet<>(first);
        resultSet.addAll(second);
        return resultSet;
    }

    public static void main(String[] args) {
       Set<Integer> a = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 7, 7));

        Set<Integer> b = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8, 9));

        Set<Integer> union = getUnion(a, b);
        Set<Integer> cross = getCross(a, b);
        System.out.println("union"+union);
        System.out.println("cross"+cross);
    }
}
