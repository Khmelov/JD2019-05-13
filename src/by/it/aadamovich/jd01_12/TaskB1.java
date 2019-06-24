package by.it.aadamovich.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {

        Map<String, Integer> words = new HashMap<>();

        Scanner sc = new Scanner(System.in);
        String line;
        Pattern p = Pattern.compile("[\\w']+");
        Matcher m;

        while (!(line = sc.nextLine()).equals("end")) {
            m = p.matcher(line);
            while (m.find()) {
                Integer count = words.getOrDefault(m.group(), 0);
                words.put(m.group(), count + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : words.entrySet())
            System.out.println(entry);
    }
}

