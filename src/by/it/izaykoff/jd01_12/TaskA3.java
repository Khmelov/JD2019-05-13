package by.it.izaykoff.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scr = new Scanner(System.in);
        String next = scr.next();
        int posZero = 0;
        while (!next.equals("end")){
            Integer element = Integer.parseInt(next);
            if (element < 0)
                list.add(element);
            else if (element == 0)
                list.add(posZero,element);
            else list.add(posZero++,element);
        }
        System.out.println(list);
    }
}
