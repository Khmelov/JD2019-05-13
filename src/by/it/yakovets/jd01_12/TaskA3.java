package by.it.yakovets.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        String vvod;
        int pos = 0;
        while (!(vvod = sc.next()).equals("end")) {
            Integer value = Integer.valueOf(vvod);
            if (value > 0)
                list.add(pos++, value);
            else if (value == 0)
                list.add(pos, 0);
            else
                list.add(value);
        }
        System.out.println(list);

    }
}
