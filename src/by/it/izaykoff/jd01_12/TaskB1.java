package by.it.izaykoff.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();

        for (; ; ) {
            String nextLine = sc.nextLine();
            if (nextLine.equals("end")) {
                break;
            }
            String[] list = nextLine
                    .replaceAll("[-,./!?—;:\"()]", "")
                    .trim()
                    .split(" ");

            for (String elem : list) {
                map.put(elem, map.containsKey(elem) ? map.get(elem) + 1 : 1);
            }
        }
        System.out.println(map);
    }
}
