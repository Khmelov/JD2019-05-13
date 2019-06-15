package by.it.guchek.jd01_12;

import java.util.*;

public class TaskA2 {

    private static Set<Integer> getCross(Set<Integer> one, Set<Integer> two){

        Set<Integer> result= new HashSet<>(one);
        result.retainAll(two);   //retain - пересечение множеств
        return result;
    }

    private static Set<Integer> getUnion(Set<Integer> one, Set<Integer> two){

        Set<Integer> result= new HashSet<>(one);
        result.addAll(two);
        return result;
    }

    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1,2,3,4,4,6,7,7,9,10));
        HashSet<Integer> hashSet = new HashSet<>(Arrays.asList(3,4,4,5,5,6,7,7,9));
        System.out.println(getCross (treeSet, hashSet));
        System.out.println(getUnion (treeSet, hashSet));

    }


}
