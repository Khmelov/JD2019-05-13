package by.it.dnevar.jd01_12;

import java.util.*;

public class TaskC1 {
    private static Map<Integer,String> c1 = new TreeMap<>();
    private static Random randomNum = new Random(39);

    public static void main(String[] args) {
        TaskC1 instance = new TaskC1();

        Scanner sc=new Scanner(System.in);
        String line;
        while (!(line = sc.next()).equals("end")){
            Integer key = randomNum.nextInt(1000);

            c1.put(key,line);
        }
        System.out.println(c1);
        System.out.println(removeDuplicates(c1));

    }

    private static Map<Integer,String> removeDuplicates(Map<Integer, String> c1) {
        Map<Integer,String> newC1 = new TreeMap<>();
        Set<Integer> keys = c1.keySet();
        for (Integer key : keys) {
            String value = c1.get(key);
            if (!newC1.containsValue(value)) {
                newC1.put(key, value);
            }
        }
        return newC1;
    }


}
