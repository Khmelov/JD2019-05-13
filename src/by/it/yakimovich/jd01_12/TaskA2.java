package by.it.yakimovich.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {
    private static Set<Integer> getCross(Set<Integer>first,Set<Integer>second){
        Set<Integer> resultSet=new HashSet<>(first);
        first.retainAll(second);
        return resultSet;
    }
    private static Set<Integer> getUnion(Set<Integer>first,Set<Integer>second){
        Set<Integer> resultSet=new HashSet<>(first);
        first.addAll(second);
        return resultSet;
    }

    public static void main(String[] args) {
        int[] arrA = {1, 2, 3, 4, 5, 6, 7, 7, 7};
        //List<Integer> listA = Arrays.asList(arrA);
     //   Set<Integer> a = new HashSet<>(listA);

        int[] arrB = {1, 2, 3, 4, 5, 6, 7, 7, 7};
        //List<Integer> listB = Arrays.asList(arrB);
       // Set<Integer> b = new HashSet<>(listB);

        /*Set<Integer> union = getUnion(a, b);
        Set<Integer> cross = getCross(a, b);
        System.out.println("union"+union);
        System.out.println("cross"+cross);*/
    }
}
