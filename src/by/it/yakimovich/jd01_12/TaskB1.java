package by.it.yakimovich.jd01_12;

import java.util.*;

public class TaskB1 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>();
        Scanner scanner=new Scanner(System.in);
        String str;
        for (int i = 0; i<list.size() ; i++) {
            if (list.get(i)!="end")
            list.add(scanner.next());
             }

        //     while(!(scr= scanner.next()).equals("end")){

        System.out.println(list);

    }
}
