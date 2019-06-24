package by.it.kobrinets.jd01_12;


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;
        Map<String, Integer> map = new HashMap<>();
        while (!(line = scanner.nextLine()).equals("end")) {
            line = line.trim();
            for (String str : line.split("[ /,+.;]")) {
                if (map.containsKey(str))
                    map.put(str, map.get(str) + 1);
                else {
                    map.put(str, 1);
                }
            }
            map.remove("");
        }
        System.out.print(map);
    }


}