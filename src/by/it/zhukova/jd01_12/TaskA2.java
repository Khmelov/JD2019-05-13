package by.it.zhukova.jd01_12;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class TaskA2 {

    private static Set<Integer> getUnion (Set<Integer> one,Set<Integer> two){
        Set<Integer> result =new HashSet<>(one);
        result.addAll(two);
        return result;
    }
    private static Set<Integer> getCross (Set<Integer> one,Set<Integer> two){
        Set<Integer> result =new HashSet<>(one);
        result.retainAll(two);
        return result;
    }
    public static void main(String[] args) {
       //Integer [] c= {3,5,8,2,5,7,3,4,5,1,4,6};
       // List<Integer> c2 = Arrays.asList(c);
       // HashSet<Integer> a = new HashSet<>(с2));
        // преобразованные строки
        Set<Integer> a = new HashSet<>(Arrays.asList(3,5,8,2,5,7,3,4,5,1,4,6));
        Set<Integer> b = new TreeSet<>(Arrays.asList(1,12,5,9,14,15,18,4,4,4,6,6));
        System.out.println("Множество a: "+a);
        System.out.println("Множество b: "+b);
        Set<Integer> cross = getCross(a, b);
        System.out.println("cross:"+cross);
        Set<Integer> union = getUnion(a, b);
        System.out.println("union: "+union);
    }
}
