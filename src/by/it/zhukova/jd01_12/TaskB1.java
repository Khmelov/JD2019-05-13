package by.it.zhukova.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> wordMap = new HashMap<>();
        Pattern pattern =Pattern.compile("[a-zA-Z]+[-']*[a-zA-Z]*");
        for (; ; ) {
            String enter = scanner.next();
            if (enter.equals("end")) break;
            Matcher matcher = pattern.matcher(enter);
          if (matcher.find()){
              String  word = matcher.group();
            if (wordMap.containsKey(word))
                wordMap.put(word,wordMap.get(word)+1);
            else wordMap.put(word,1);
        }}
        Set<Map.Entry<String, Integer>> wordset = wordMap.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = wordset.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+ "="+next.getValue());
        }
    }
}
