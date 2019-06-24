package by.it.trudnitski.jd01_12;

import java.util.*;

public class TaskB1 {
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer count;
        for (; ; ) {
            String next = sc.next();
            String words = next.replaceAll("[^a-zA-Z\\\\']", "");
            if (next.equals("end")) break;
            list.add(words);
        }

        System.out.println(list);
        Map<String, Integer> map = new HashMap<>();
        for (String s : list) {
            count = map.get(s);
            map.put(s, count == null ? 1 : count + 1);
        }
        System.out.println(map);

    }
}
