package by.it.trudnitski.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskA2 {
    private Set<Integer> set=new HashSet<>();

    private static Set<Integer> getUnion(Set<Integer> first, Set<Integer> second){
        Set<Integer> resultSet=new HashSet<>(first);
        resultSet.addAll(second);
        return resultSet;
    }
    private static Set<Integer> getCross(Set<Integer> first, Set<Integer> second){
        Set<Integer> resultSet=new HashSet<>(first);
        resultSet.retainAll(second);
        return resultSet;
    }

    public static void main(String[] args) {
       Integer[] arr={1,1,2,2,3,3,4,4,5,5,6,7,8};
        List<Integer> listA= Arrays.asList(arr);
        Set<Integer> a=new HashSet<>(listA);
        Set<Integer> b=new HashSet<>(Arrays.asList(6,6,7,7,8,8,9,9));
        System.out.println(a+"b");
        System.out.println(b+"b");
        Set<Integer> union=getUnion(a,b);
        Set<Integer> cross=getCross(a,b);
        System.out.println(union);
        System.out.println(cross);
    }
}
