package by.it.guchek.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {
    static LinkedList <String> listStr = new LinkedList<>();
    static LinkedList <Double> listD = new LinkedList<>();
    static int countErrors = 1;
    public static void readData() throws InterruptedException {

        try {
            listD.addFirst(Double.parseDouble(listStr.getFirst()));
        } catch (NumberFormatException e) {
            //countErrors++;

            if (countErrors == 5)
                throw e;
            Thread.sleep(100);

            for (Double elemDoubl : listD) {

                System.out.print(elemDoubl + " ");

            }

            System.out.println();
            countErrors++;

        }
    }


    public static void main(String[] args) throws InterruptedException {

        Scanner sc = new Scanner(System.in);
        String line;
        Double var;
        while (true){
            line = sc.nextLine();
            //var=Double.parseDouble(line);
            listStr.addFirst(line);
            readData();

        }

    }

}
