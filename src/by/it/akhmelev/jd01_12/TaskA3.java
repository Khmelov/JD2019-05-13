package by.it.akhmelev.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        int posZero=0;
        for (; ; ) {
            String next = sc.next();
            if (next.equals("end"))
                break;
            Integer element=Integer.parseInt(next);
            if (element<0)
                list.add(element);
            else if (element==0)
                list.add(posZero,element);
            else
                list.add(posZero++,element);
        }
        System.out.println(list);

    }
}
