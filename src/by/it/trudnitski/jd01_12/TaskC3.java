package by.it.trudnitski.jd01_12;

import java.util.*;

public class TaskC3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> list=new TreeSet<>();
        for (;;) {
            String next=sc.next();
            if(next.equals("end"))break;
            list.add(next);
        }
                System.out.println(list);
    }
}
