package by.it.zhukova.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
       List<Integer> number = new ArrayList <>();
        Scanner scanner = new Scanner(System.in);
        int posZero=0;
        for (; ; ) {
            String i=scanner.next();
        if (i.equals("end")) break;
            Integer num = Integer.parseInt(i);
            if (num<0) number.add(num);
            else if (num==0) number.add(posZero,num);
            else number.add(posZero++,num);
        }
        System.out.println(number);
    }
}
