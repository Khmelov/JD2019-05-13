package by.it.aadamovich.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String line;
        Pattern p = Pattern.compile("[]\\[)}{(]");
        Matcher m;

        while (!(line = sc.nextLine()).equals("end")) {
            m = p.matcher(line);
            while (m.find()) {
                list.add(m.group());
            }
        }
        System.out.println(list + "\nСкобки расставлены верно: " + checkBrackets(list));
    }

    /*
 Map key contains close bracket (one of three types)
 and map value contains appropriate open bracket
   */
    private static boolean checkBrackets(List<String> list) {

        Map<String, String> map = new HashMap<>();
        map.put(")", "(");
        map.put("]", "[");
        map.put("}", "{");

        for (int i = 1; i < list.size(); ) {
            if (map.containsKey(list.get(0))) {
                return false;

            } else if (map.containsKey(list.get(i))) {
                if (list.get(i - 1).equals(map.get(list.get(i)))) {
                    list.remove(i);
                    list.remove(i - 1);
                    i -= 2;

                } else {
                    return false;
                }
            }
            i++;
        }
        return list.isEmpty();
    }
}


