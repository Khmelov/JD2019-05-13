package by.it.aadamovich.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        String line;
        int position = 0;

        while (!(line = sc.next()).equals("end")) {
            Integer next = Integer.valueOf(line);
            if (next > 0) list.add(position++, next);
            else if (next < 0) list.add(next);
            else list.add(position, next);
        }
        System.out.println(list);
    }
}
