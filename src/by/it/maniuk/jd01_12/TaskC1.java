package by.it.maniuk.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        Map<Integer, String> map = new TreeMap<>();
        while (! (s = scanner.nextLine()).equals("end")) {
            s = s.trim();
            for (String str : s.split("[ \"/,+.;]")) {
                map.put(str.hashCode() & 0xfffffff, str);
            }
        }


        System.out.print(map);
        TreeMap<Integer, String> list = new TreeMap<>(map);
       Comparator c = new Comparator<Map.Entry<Integer, String>>() {
            @Override
            public int compare(Map.Entry<Integer, String> o1, Map.Entry<Integer, String> o2) {
                return o1.getValue().compareToIgnoreCase(o2.getValue());
            }
        };


    }}




