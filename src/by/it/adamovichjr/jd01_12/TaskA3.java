package by.it.adamovichjr.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String line;
        List<Integer>list = new ArrayList<>();
        int zeroPos = 0;
        while (!(line = sc.next()).equals("end")){
            Integer number = Integer.valueOf(line);
            if(number == 0){
                list.add(zeroPos,number);
            }
            else if(number<0){
                list.add(number);
            }
            else {
                list.add(zeroPos,number);
                zeroPos++;

            }
        }
        System.out.println(list);

    }
}
