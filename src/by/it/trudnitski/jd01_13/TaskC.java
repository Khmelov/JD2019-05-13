package by.it.trudnitski.jd01_13;

import java.util.*;

public class TaskC {
    private static LinkedList<Double> list = new LinkedList<>();

    public static void main(String[] args) throws Exception {
        readData();


    }

    private static void readData() throws Exception {
        int count = 0;
        Scanner sc = new Scanner(System.in);
        while (true){
        try{
        list.push(Double.parseDouble(sc.next()));
        }catch(NumberFormatException e){
        Thread.sleep(100);

            for (Double aDouble : list) {
                System.out.print(aDouble+" ");
            }
        System.out.println();
        if (++count == 5) {
            throw new Exception();
        }
    }
}
    }
            }
