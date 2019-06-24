package by.it.buymistrov.jd01_12;

import java.util.*;

public class TaskC1 {

    private static Random generator = new Random();
    private static Map<String, String> mapSort = new TreeMap<>();
    private static Map<String, String> nameMap = new TreeMap<>();
    private static Set<Map.Entry<String, String>> set = nameMap.entrySet();
    private static Set<Map.Entry<String, String>> setMapSort = mapSort.entrySet();
    private static Set<String> resultSet = nameMap.keySet();

    public static void main(String[] args) {

        //Заполнение
        Scanner sc = new Scanner(System.in);
        String name;
        while (!(name = sc.nextLine()).equals("end")) {
            int gen = 1 + generator.nextInt(999) + generator.nextInt(999999);
            nameMap.put(Integer.toString(gen), name);
        }

        //Вывод с дубликатами
        for (Map.Entry<String, String> stringStringEntry : set) {
            System.out.println(stringStringEntry.getValue() + " - " + stringStringEntry.getKey());
        }


        System.out.println();


        //Удаление дубликатов и вывод
        for (String s : resultSet) {
            String str = nameMap.get(s);
            if (!(mapSort.containsValue(str))) {
                mapSort.put(s, str);
            }
        }

        System.out.println("Result:");
        for (Map.Entry<String, String> stringStringEntry : setMapSort) {
            System.out.println(stringStringEntry.getValue() + " - " + stringStringEntry.getKey());
        }
    }
}

