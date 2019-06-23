package by.it.yakimovich.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> arrayStr = new ArrayList<String>();
        Map<String, Integer> map = new HashMap<>();
        String str;
        Pattern pattern =Pattern.compile("[a-zA-Z]+[-']*[a-zA-Z]*");
        while (!(str = scanner.next()).equals("end")) {
            String strN = str.replaceAll("[\\s:;.,-]+", "");
            arrayStr.add(strN);
            Matcher matcher = pattern.matcher(strN);
            if (matcher.find()){
                String  word = matcher.group();
                if (map.containsKey(word))
                    map.put(word,map.get(word)+1);
                else map.put(word,1);
            }}
        Set<Map.Entry<String, Integer>> setMap = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = setMap.iterator();
        while (iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next.getKey()+ "="+next.getValue());
        }
    }
}

