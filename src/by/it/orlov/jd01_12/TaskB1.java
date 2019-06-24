package by.it.orlov.jd01_12;



import java.util.*;


public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String afterTrim;
        Map<String, Integer> map = new HashMap<>();
        while (!(afterTrim = scanner.nextLine()).equals("end")){
            afterTrim = afterTrim.trim();
            for (String str: afterTrim.split("[ /,+.;]")){
                if (map.containsKey(str))
                    map.put(str, map.get(str)+1);
                else {map.put(str,1);}
            }
            map.remove("");
        }
        System.out.print(map);
    }


}