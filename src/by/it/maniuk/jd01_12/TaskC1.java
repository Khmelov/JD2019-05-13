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
                map.put((str.hashCode() & 0xfffffff) + new Random().nextInt(999), str);
            }
        }
        System.out.print(map);
        Set<String> mySet = new HashSet<>();
        for (Iterator itr = map.entrySet().iterator(); itr.hasNext(); ) {
            Map.Entry<String, String> entrySet = (Map.Entry) itr.next();
            String value = entrySet.getValue();
            if (! mySet.add(value)) {
                itr.remove();
            }
        }
        System.out.println(map);


        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> me : entrySet) {
            System.out.println(me.getKey() + " : " + me.getValue());

        }
    }
}


















