package by.it.guchek.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        String stroke;
        int poz=0;
        while (!(stroke = scan.next()).equals("end") ){

            //Integer value = Integer.valueOf(stroke);
            /*if (value>0)
                array.add(poz++,value);
            else if (value==0)
                array.add(poz,0);
            else array.add(value);}*/

            if (stroke.equals("end"))
                break;
            Integer element=Integer.parseInt(stroke);
            if (element<0)
                array.add(element);
            else if (element==0)
                array.add(poz,element);
            else
                array.add(poz++,element);
        }

        System.out.println(array);
    }
}
