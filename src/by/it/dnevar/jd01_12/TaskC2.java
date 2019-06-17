package by.it.dnevar.jd01_12;

import java.util.*;

public class TaskC2 {

    private static Map<Integer,String> c2 = new TreeMap<>();
    private static Random randomNum = new Random(39);

    public static void main(String[] args) {
        TaskC2 instance = new TaskC2();

        Scanner sc=new Scanner(System.in);
        String line;
        while (!(line = sc.next()).equals("end")){
            Integer key = randomNum.nextInt(1000);

            c2.put(key,line);
        }
        System.out.println(c2);
        System.out.println(removeDuplicates(c2));

    }

    private static Map<Integer,String> removeDuplicates(Map<Integer, String> c2) {
        Map<Integer,String> newC2 = new TreeMap<Integer, String>();
        Set<Integer> keys = c2.keySet();
        for (Integer key : keys) {
            String value = c2.get(key);
            if (!newC2.containsValue(value)) {
                newC2.put(key, value);
            }
        }
        return newC2;
    }


}