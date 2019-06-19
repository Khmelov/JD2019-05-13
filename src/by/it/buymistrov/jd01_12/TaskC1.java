package by.it.buymistrov.jd01_12;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;
import java.util.*;

public class TaskC1 {

    private static Random generator = new Random();
    private static TreeSet<String> setT = new TreeSet<>();
    private static Map<String, String> mapV = new HashMap<>();
    private static Set<Map.Entry<String, String>> set = mapV.entrySet();
    private static Set<String> set1 = new HashSet<>();
    private static BiMap<String, String> myBiMap = HashBiMap.create();

    public static void main(String[] args) {


        //заполнение
        Scanner sc = new Scanner(System.in);
        String name;
        while (!(name = sc.nextLine()).equals("end")) {
            int gen = 1 + generator.nextInt(99) + generator.nextInt(9999);
            mapV.put(Integer.toString(gen), name);
        }

        //сортировка
        for (Map.Entry<String, String> key : set) {
            setT.add(key.getKey());
        }

        //вывод с дубликатами
        for (String s : setT) {
            System.out.println(mapV.get(s) + " - " + s);
            set1.add(mapV.get(s));
            myBiMap.put(mapV.get(s), s);
        }


        System.out.println();

        //вывод результата
        // НЕ БУДЕТ РАБОТАТЬ БЕЗ КОЛЛЕКЦИЙ ОТ ГУГЛА!(но это не точно)
        System.out.println("Result");
        for (String s : set1) {
            System.out.println(s + " - " + myBiMap.get(s));
        }


    }


}

