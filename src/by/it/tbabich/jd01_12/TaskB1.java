package by.it.tbabich.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    private static Map<String, Integer> words = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")){
            parseLine(line);
        }
        Set<Map.Entry<String, Integer>> entries = words.entrySet();
        for (Map.Entry<String, Integer> element: entries) {
            System.out.println(element.getKey() + "=" + element.getValue());
        }
    }

    private static void parseLine(String line){
        Pattern pattern = Pattern.compile("[a-zA-Z']+");
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()){
            String word = matcher.group();
            if (words.containsKey(word)){
                words.replace(word, words.get(word) + 1);
            }
            else words.put(word, 1);
        }
    }
}
