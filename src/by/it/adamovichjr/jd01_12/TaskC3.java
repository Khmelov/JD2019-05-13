package by.it.adamovichjr.jd01_12;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        LinkedList<String>list = new LinkedList<>();
        Pattern p = Pattern.compile("[{\\[\\(}\\]\\)]");
        Matcher m;

        while (!(line = sc.nextLine()).equals("end")) {
            m = p.matcher(line);
            while (m.find()){
                list.add(m.group());
            }
        }

        Set<String>open = new HashSet<>();
        open.add("{"); open.add("("); open.add("[");

        Set<String>close = new HashSet<>();
        close.add("}"); close.add(")"); close.add("]");

        Set<String>openAndClosed = new HashSet<>();
        openAndClosed.add("{}"); openAndClosed.add("()"); openAndClosed.add("[]");

        boolean reult = true;

        for (int i = 1; i < list.size(); ) {
            if(close.contains(list.get(0))){
                reult = false;
                break;
            }
            if(close.contains(list.get(i)) && !openAndClosed.contains(list.get(i-1)+list.get(i))){
                reult = false;
                break;
            }
            else if(close.contains(list.get(i))) {
                list.remove(i-1);
                list.remove(i-1);
                if(!list.isEmpty() && i !=1){
                    i = i-2;
                }else if (i == 1){
                    i= i -1;
                }else {
                    break;
                }
            }
            else if(open.contains(list.get(i))){
                i++;
            }
        }
        if(!list.isEmpty()){
            reult = false;
        }

        System.out.println(reult);
    }

}