package by.it.adamovichjr.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> hash = new HashSet<>(Arrays.asList(1,2,1,3,3,5,5,6,6,6,7,7,6,4));
        Set<Integer> tree = new TreeSet<>(Arrays.asList(4,4,4,5,5,6,7,7,8,9,10,10,10));
        System.out.println(getCross(hash,tree));
        System.out.println(getUnion(hash,tree));
    }
    static Set<Integer> getUnion(Set<Integer> setA, Set<Integer>setB){
        Set<Integer>result = new TreeSet<>(setA);
        result.addAll(setB);
        return result;
    }
    static Set<Integer> getCross(Set<Integer> setA, Set<Integer>setB){
        Set<Integer>result = new TreeSet<>(setA);
        result.retainAll(setB);
        return result;
    }

}
