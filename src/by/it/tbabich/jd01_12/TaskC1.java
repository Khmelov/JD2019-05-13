package by.it.tbabich.jd01_12;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

public class TaskC1 {

    private static TreeMap<Integer, String> map = new TreeMap<>();

    public static void main(String[] args) {
        initMap();
        printMap();
    }

    private static void printMap() {
        Set<Map.Entry<Integer, String>> entries = map.entrySet();
        for (Map.Entry<Integer, String> element : entries) {
            System.out.println(element.getKey() + "=" + element.getValue());
        }
    }

    private static void initMap() {
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("end")) {
            map.put(line.hashCode(), line);
        }
    }
}
