package by.it.izaykoff.jd01_13;


import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TaskC {
    public static Scanner scan;


    public static void main(String[] args) throws Exception {
        scan = new Scanner(System.in);
        readData();
    }

    static void readData() throws NumberFormatException, InterruptedException {
        ArrayList<Double> list = new ArrayList<>();
        int count = 0;

        while (true) {
            try {

                list.add(Double.parseDouble(scan.nextLine()));

            } catch (NumberFormatException e) {

                Thread.sleep(100);
                ListIterator listIterator = list.listIterator(list.size());
                while (listIterator.hasPrevious()) {
                    System.out.print(listIterator.previous() + " ");
                }
                count++;

                if (count > 4) {
                    throw e;
                }
            }

        }

    }
}
