package by.it.adamovichjr.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuffer sb = new StringBuffer();
        String words;
        while (!(words = sc.next()).equals("end")){
            sb = sb.append(" ").append(words);
        }
        HashMap<String, Integer> table = createTable(sb.toString());
        System.out.println(table);

    }

    static HashMap<String,Integer>createTable(String text){
        HashMap<String,Integer>map = new HashMap<>();
        Pattern pattern = Pattern.compile("\\w+[']?\\w*");
        Matcher matcher = pattern.matcher(text);
        Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
        while (matcher.find()) {
            String word = matcher.group();

            boolean newWord = true;
            for (Map.Entry<String, Integer> entry : entrySet) {
                if ((entry.getKey()).equals(word)) {
                    entry.setValue(entry.getValue() + 1);
                    newWord = false;
                }
            }
            if (newWord) {
                map.put(word, 1);
            }
            if(map.containsKey("don't") && map.containsKey("isn't")){
                map.put("don't",map.get("don't") + map.get("isn't"));
                map.put("isn't",map.get("don't") + map.get("isn't"));

            }
        }
        return map;
    }
}
