package by.it.yakovets.jd01_12;


import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {

    public static void main(String[] args) {
        HashMap<String, Integer> words = new HashMap<>();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String i = sc.nextLine();
            Pattern pattern = Pattern.compile("[A-Za-z']+");
            Matcher matcher = pattern.matcher(i);

            while (matcher.find()) {
                String word = matcher.group();
                if (!(word.equals("end"))) {
                    if (!(words.containsKey(word))) {
                        words.put(word, 1);
                    } else {
                        int count = words.get(word);
                        words.replace(word, ++count);
                    }
                }
            }
        }
//        System.out.println(words);
        Set<Map.Entry<String, Integer>> setv = words.entrySet();

        Iterator<Map.Entry<String, Integer>> iter = setv.iterator();
        while (iter.hasNext()) {
            Map.Entry<String, Integer> me = iter.next();
            System.out.println(me.getKey() + "=" + me.getValue());
        }

    }
}



