package by.it.livanovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String str;
        int pos = 0;
        while (!((str = sc.next()).equals("end"))) {
            Integer value = Integer.valueOf(str);
            if (value > 0) {
                array.add(pos++, value);
            } else if (value == 0) {
                array.add(pos, 0);
            } else array.add(value);
        }
        System.out.println(array);
    }
}
