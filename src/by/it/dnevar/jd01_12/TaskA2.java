package by.it.dnevar.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {
    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(1,1,1,2,2,3,3,4,4,4,5,5,5));
        Set<Integer> b = new TreeSet<>(Arrays.asList(4,4,4,5,5,5,6,6,6,7,7,7));

        System.out.println("a: "+a);
        System.out.println("b: "+b);
        Set<Integer> cross = getCross(a,b);
        Set<Integer> union = getUnion(a,b);
        System.out.println("cross: "+cross);
        System.out.println("union "+union);

    }

    private static Set<Integer> getUnion (Set<Integer> first, Set<Integer> second){
        Set<Integer> resultSet = new HashSet<>(first);
        resultSet.addAll(second);
        return resultSet;
    }

    private static Set<Integer> getCross (Set<Integer> first, Set<Integer> second){
        Set<Integer> resultSet = new HashSet<>(first);
        resultSet.retainAll(second);
        return resultSet;
    }
}
