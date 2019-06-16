package by.it.maniuk.jd01_12;



import java.util.*;


public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s;
        Map<String, Integer> map = new HashMap<>();
        while (!(s = scanner.nextLine()).equals("end")){
            s = s.trim();
            for (String str: s.split("[ /,+.;]")){
                if (map.containsKey(str))
                    map.put(str, map.get(str)+1);
                else {map.put(str,1);}
            }
            map.remove("");
        }
        System.out.print(map);
    }


}