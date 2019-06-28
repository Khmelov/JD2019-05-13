package by.it.zhukova.jd01_12;

import java.util.*;

public class TaskC2 {
         private static <T extends Number> Set<T> getUnion (Set <Set<T> > lots){
            Iterator<Set<T>> iterator = lots.iterator();
            Set<T> result =new HashSet<>(iterator.next());
            while (iterator.hasNext()) {
                result.addAll(iterator.next());
            }
            return result;
        }
     private static <T extends Number> Set<T> getCross (Set <Set<T> > lots){
        Iterator<Set<T>> iterator = lots.iterator();
        Set<T> result =new HashSet<>(iterator.next());
        while (iterator.hasNext()) {
            result.retainAll(iterator.next());
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Integer> a = new HashSet<>(Arrays.asList(3,5,8,2,5,7,3,4,5,1,4,6));
        Set<Integer> b = new TreeSet<>(Arrays.asList(1,12,5,9,14,15,18,4,4,4,6,6));
        Set<Integer> c = new HashSet<>(Arrays.asList(4,56,23,12,34,1,2,6,7));
        Set<Set<Integer>> lots = new HashSet<Set<Integer>>();
        lots.add(a);
        lots.add (b);
        lots.add(c);
        System.out.println("Множество a: "+a);
        System.out.println("Множество b: "+b);
        System.out.println("Множество c: "+b);
      Set<Integer> cross = getCross(lots);
       System.out.println("cross:"+cross);
       Set<Integer> union = getUnion(lots);
       System.out.println("union: "+union);
        Set<Double> adouble = new HashSet<>();
        int N=14;
         for (int i = 0; i < N; i++) {
          double number = Math.random()*10;
          adouble.add(number);
        }
        Set<Double> bdouble = new TreeSet<>();
        N=19;
        for (int i = 0; i < N; i++) {
            double number = Math.random()*10;
            bdouble.add(number);
        }

        Set<Double> cdouble = new HashSet<>();
        N=100;
        for (int i = 0; i < N; i++) {
            double number = Math.random()*10;
            cdouble.add(number);
        }

        Set<Set<Double>> lotsdouble = new HashSet<Set<Double>>();
        lotsdouble.add(adouble);
        lotsdouble.add (bdouble);
        lotsdouble.add(cdouble);
        System.out.println("Множество adouble: "+adouble);
        System.out.println("Множество bdouble: "+bdouble);
        System.out.println("Множество cdouble: "+bdouble);
        Set<Double> crossdouble = getCross(lotsdouble);
        System.out.println("cross:"+crossdouble);
        Set<Double> uniondouble = getUnion(lotsdouble);
        System.out.println("union: "+uniondouble);
    }
}
