package by.it.trudnitski.jd01_12;

import java.util.*;

public class TaskC2 {

    private static < T extends Number> Set<T> getUnion(Set<? extends T>... n){
        Set<T> resultSet=new HashSet<>(n[0]);
        for (Set<? extends T> arg : n) {
            resultSet.addAll(arg);
        }
        return resultSet;
    }
    private static <T extends Number>Set<T> getCross(Set<? extends T>...n){
        Set<T> resultSet=new HashSet<>(n[0]);
        for (Set<? extends T> ts : n) {
            resultSet.retainAll(ts);
        }
        return resultSet;
    }

    public static void main(String[] args) {
        Integer[] arr={1,1,2,2,3,3,4,4,5,5,6,7,8};
        Double[]arr1={1.0,5.0,2.0,3.0,4.0,6.0};
        List<Integer> listA= Arrays.asList(arr);
        Set<Integer> a=new HashSet<>(listA);
        Set<Integer> b=new HashSet<>(Arrays.asList(6,6,7,7,8,8,9,9));
        Set<Double>c=new HashSet<>(Arrays.asList(arr1));
        System.out.println(a+" a");
        System.out.println(b+" b");
        System.out.println(c+" c");
        System.out.println(getCross(a,b));
        System.out.println(getUnion(b,c));
        System.out.println(getUnion(a,b,c));
    }
}
