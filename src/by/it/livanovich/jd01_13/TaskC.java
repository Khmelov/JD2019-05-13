package by.it.livanovich.jd01_13;

import java.util.*;

public class TaskC {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str;
        List <Double> list= new ArrayList<>();
        int count=0;
        while (!(str=sc.next()).equals("end")){
            if (!sc.hasNextDouble()) {
                readData();
                if (count==5){throw new Exception();}
                else {
                    ListIterator<Double> iterator = list.listIterator();
                    while (iterator.hasPrevious()) {
                        System.out.println(iterator.previous());
                    }
                }
                count++;
            }
            else {
                double number=Double.valueOf(str);
                list.add(number);
            }
        }
    }
    static void readData (){
        try {
            Thread.sleep(100);
        }
        catch (NumberFormatException | InterruptedException e){
            System.out.println(e);
        }
    }
}
