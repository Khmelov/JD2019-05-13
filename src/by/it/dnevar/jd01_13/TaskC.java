package by.it.dnevar.jd01_13;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskC {

    private static List<Double> list = new ArrayList<>();
    private static int countException=0;
    private static Scanner sc;

    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        sc=new Scanner(System.in);
        readData();
    }

    private static void readData() throws NumberFormatException, InterruptedException {
        for(;;){
            try{
                double num = Double.parseDouble(sc.nextLine());
                System.out.println(num);
                list.add(num);
            } catch(NumberFormatException e){
                countException++;
                Thread.sleep(100);
                for (int i = list.size()-1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
                if(countException==5){
                    throw e;
                }
            }
        }
    }
}
