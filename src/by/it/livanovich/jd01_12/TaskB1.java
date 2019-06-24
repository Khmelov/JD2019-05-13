package by.it.livanovich.jd01_12;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Map<String, Integer> words = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        String str;
        while (!((str = sc.next().replaceAll("[,.();:]","")).equals("end"))) {
            if (!words.containsKey(str)) {
                words.put(str, 1);
            } else words.put(str, words.get(str) + 1);
        }
        for (Map.Entry<String, Integer> entry : words.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }
}
