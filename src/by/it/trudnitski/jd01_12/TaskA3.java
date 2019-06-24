package by.it.trudnitski.jd01_12;

import java.util.*;

public class TaskA3 {
    private static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int pozZero = 0;
        for (; ; ) {
            String next = sc.next();
            Integer element = Integer.parseInt(next);
            if (next.equals("end")) break;
            if (element < 0) {
                list.add(element);
            } else if (element == 0) {
                list.add(pozZero,0);
            } else if (element > 0) {
                list.add(pozZero++, element);
                }
            System.out.println(list);
            }
        }
    }

