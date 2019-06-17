package by.it.adamovichjr.jd01_12;

import java.util.*;

public class TaskC2 {
    public static void main(String[] args) {
        Set<Integer> hash = new HashSet<>(Arrays.asList(2,1,3,3,5,5,6,6,6,7,7,6,4));
        Set<Double> tree = new TreeSet<>(Arrays.asList(4.0, 4.5, 4.0, 5.0, 5.0, 6.3, 7.0, 7.0, 8.0, 9.0, 10.0, 10.0));

        Set<Long> hashL = new HashSet<>(Arrays.asList(7L,15L,10L,5L));

        System.out.println("Cross " + getCross(tree,hash,hashL));
        System.out.println("Union " +getUnion(tree,hash,hashL));
    }
    private static Set<Double> getUnion(Set<? extends Number> ...args){
        Set<Double>result = new TreeSet<>();
        for (Set<? extends Number> arg : args) {
            for (Number elem : arg) {
                result.add(elem.doubleValue());
            }
        }
        return result;
    }

   private static Set<Double> getCross(Set<? extends Number> ...args){
       Set<Double>result = new TreeSet<>();
       Set<Double>buffer = new HashSet<>();
       for (int i = 0; i < args.length; i++) {
           for (Number number : args[i]) {
               buffer.add(number.doubleValue());
           }
           if(result.isEmpty() && i == 0){
               result.addAll(buffer);
           }
           result.retainAll(buffer);
           buffer.clear();
           if(result.isEmpty()) break;
       }
       return result;
   }
}
