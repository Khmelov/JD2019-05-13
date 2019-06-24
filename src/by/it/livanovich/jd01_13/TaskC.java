package by.it.livanovich.jd01_13;

import java.util.*;

public class TaskC {

    public static void main(String[] args) throws Exception {
        Scanner sc=new Scanner(System.in);
        String str;
        List <Double> list= new ArrayList<>();
        int count=0;
        while (!(str=sc.next()).equals("end")) {
            try {
                double number=Double.valueOf(str);
                list.add(number);
            }
            catch (NumberFormatException e){

                readData();
                for (int i = list.size()-1; i >= 0; i--) {
                    System.out.print(list.get(i)+" ");
                }
                count++;
                if (count==5){throw new Exception();}
            }
        }
    }
    static void readData (){
        try {
            Thread.sleep(100);
        }
        catch (InterruptedException e){
            System.out.println(e);
        }
    }
}
