package by.it.livanovich.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String str;
        List <Double> list= new ArrayList<>();
        while (!(str=sc.next()).equals("end")){
            readData(str);
            double number=Double.valueOf(str);
            list.add(number);
        }
        System.out.println(list);

    }
    static void readData (String str){
        try {
            double number=Double.valueOf(str);
        }
        catch (NumberFormatException e){
            System.out.println();
                  }
    }
}
