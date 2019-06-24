package by.it.zhukova.jd01_12;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //создание карты
        Map<Integer,String> list = new TreeMap<>();
        for (; ; ) {
            String str=scanner.nextLine();
            if (str.equals("end")) break;
            //уникальный код
            int uniquekey = (int) (System.currentTimeMillis() & 0xfffffff);
            list.put(uniquekey,str);
        }
        // печать карты название-код
        System.out.println("отсортированный список:");
        print(list);
        Set<String> value = new HashSet<>();
       list= list.entrySet().stream()
                .filter(entry -> value.add(entry.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue));
        System.out.println("сжатый список:");
       print(list);
    }
    private static void print(Map<Integer, String> list) {
        Set<Map.Entry<Integer,String>> set = list.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
               while (iterator.hasNext()){
            Map.Entry<Integer,String> next = iterator.next();
            System.out.println(next.getKey()+"="+next.getValue());
        }
    }
}
