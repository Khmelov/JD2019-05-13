package by.it.dnevar.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,1,1,2,2,3,3,4,4,4,5,5,5));
        Set<Integer> b = new TreeSet<>(Arrays.asList(4,4,4,5,5,5,6,6,6,7,7,7));
        Set<Double> c = new HashSet<>(Arrays.asList(4.0,4.0,4.0,5.0,5.0,5.0,6.0,6.0,6.0,7.0,7.0,7.0));
        Set<Double> d = new TreeSet<>(Arrays.asList(4.0,4.0,5.0,5.0,5.0,5.0,6.0,6.0,5.0,7.0,8.0,8.0));
        Set<Integer> e = new HashSet<>(Arrays.asList(5,5,5,6,6,6,7,7,7,8,8,8));
        Set<String> f = new HashSet<>(Arrays.asList("a","b","c","d","e","f","g"));
        Set<String> g = new TreeSet<>(Arrays.asList("e","f","g","h","i","j","k"));


        System.out.println(getUnion(a,b,e));
        System.out.println(getCross(c,d));
        System.out.println(getCross(f,g));

    }


    @SafeVarargs
    private static <T> Set<T> getUnion (Set<T>... n){
        Set<T> resultSet=new HashSet<>(n[0]);
        for (int i = 1; i < n.length-1; i++) {
            resultSet.addAll(n[i+1]);
        }
        return resultSet;
    }


    @SafeVarargs
    private static <T> Set<T> getCross (Set<T>... n){
        Set<T> resultSet=new HashSet<>(n[0]);
        for (int i = 1; i < n.length-1; i++) {
            resultSet.retainAll(n[i]);
        }
        return resultSet;
    }
}
