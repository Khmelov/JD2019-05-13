package by.it.dilkevich.jd01_12;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskC1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String word = "";
        Map<Integer,String> mapLib = new HashMap<>();

        int unNumber = 0;
        StringBuilder sb = new StringBuilder();

        while (!word.equals("end")) {
            word = scanner.nextLine();
            if (word.equals("end"))
                break;

            else {
                sb.append(word);

                String[] split = word.split("[.]");

                for (int i = 0; i < split.length; i++) {

                    split[i] = split[i].trim();
                    if(!mapLib.containsValue(split[i]))
                    mapLib.put(unNumber++, split[i]);
                }

            }
        }
        System.out.println(sb.toString());
        System.out.println(mapLib);
    }
}
