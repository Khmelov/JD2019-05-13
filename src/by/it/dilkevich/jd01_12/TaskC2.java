package by.it.dilkevich.jd01_12;

import java.util.*;


public class TaskC2 {

    private Set<Set<? extends Number>> getCross(Map<Set<? extends Number>, Set<? extends Number>> map){

        Iterator<Map.Entry<Set<? extends Number>, Set<? extends Number>>> iterator = map.entrySet().iterator();
        Set<Set<? extends Number>> result= new HashSet<>();

        while (iterator.hasNext()){

            Set<? extends Number> temp = new HashSet<>(iterator.next().getKey());
            temp.retainAll(map.get(temp));
            result.addAll((Collection<? extends Set<? extends Number>>) temp);

        }

        return result;
    }

    private Set<Set<? extends Number>> getUnion(Map<Set<? extends Number>, Set<? extends Number>> map) {

        Iterator<Map.Entry<Set<? extends Number>, Set<? extends Number>>> iterator = map.entrySet().iterator();
        Set<Set<? extends Number>> result = new HashSet<>();

        while (iterator.hasNext()) {

            Set<? extends Number> temp = new HashSet<>(iterator.next().getKey());
            Set<? extends Number> temp2 = new HashSet<>(map.get(temp));
            result.addAll((Collection<? extends Set<? extends Number>>) temp);
            result.addAll((Collection<? extends Set<? extends Number>>) temp2);
        }

        return result;
    }


    public static void main(String[] args) {

        Set<Integer> a=new HashSet<>(Arrays.asList(1,1,2,2,3,3,4,5,6,7,7,7));
        Set<Integer> b=new HashSet<>(Arrays.asList(4,5,6,7,7,7,8,8,9,9,9,9,9,9));
        System.out.println("a: "+a);
        System.out.println("b: "+b);
        Map<Set<? extends Number>, Set<? extends Number>> myMapA = new HashMap<>();
        Map<Set<? extends Number>, Set<? extends Number>> myMapB = new HashMap<>();
        myMapA.put(a,b);
        myMapB.put(a,b);
        TaskC2 classs = new TaskC2();
        System.out.println("cross: "+ classs.getCross(myMapA));
        System.out.println("union: "+ classs.getUnion(myMapB));




    }
}
