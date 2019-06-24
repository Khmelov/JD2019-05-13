package by.it.lasotskaya.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String i;
        //String s = "this is a this is this a this yes this is a this what it may be i do not care about this";
        Map<String, Integer> words = new HashMap<>();
        while (!(i = sc.nextLine()).equals("end")) {
            String a[] = i.split("[\\s,.:;!?\"—)(]+");
            for (String str : a) {
                if (words.containsKey(str)) {
                    words.put(str, 1 + words.get(str));
                } else {
                    words.put(str, 1);
                }
            }
            System.out.println(words);
        }
    }
}


