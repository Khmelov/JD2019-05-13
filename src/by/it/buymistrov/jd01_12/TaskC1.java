package by.it.buymistrov.jd01_12;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.*;

public class TaskC1 {

    private static Random generator = new Random();
    private static TreeSet<String> nameSet = new TreeSet<>();
    private static Map<String, String> nameMap = new HashMap<>();
    private static Set<Map.Entry<String, String>> set = nameMap.entrySet();
    private static Set<String> resultSet = new HashSet<>();
    private static BiMap<String, String> resultBiMap = HashBiMap.create();

    public static void main(String[] args) {


        //заполнение
        Scanner sc = new Scanner(System.in);
        String name;
        while (!(name = sc.nextLine()).equals("end")) {
            int gen = 1 + generator.nextInt(99) + generator.nextInt(9999);
            nameMap.put(Integer.toString(gen), name);
        }

        //сортировка
        for (Map.Entry<String, String> key : set) {
            nameSet.add(key.getKey());
        }

        //вывод с сортировкой и дубликатами
        for (String s : nameSet) {
            System.out.println(nameMap.get(s) + " - " + s);
            resultSet.add(nameMap.get(s));
            resultBiMap.put(nameMap.get(s), s);
        }


        System.out.println();

        //вывод результата без дубликатов
        // НЕ БУДЕТ РАБОТАТЬ БЕЗ КОЛЛЕКЦИЙ ОТ ГУГЛА!(но это не точно)
        System.out.println("Result");
        for (String s : resultSet) {
            System.out.println(s + " - " + resultBiMap.get(s));
        }


    }


}

