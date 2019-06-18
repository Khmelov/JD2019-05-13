package by.it.izaykoff.jd01_13;


import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) throws Exception {
        readData();
    }

    static void readData() throws NumberFormatException, InterruptedException {
        Scanner scan = new Scanner(System.in);
        ArrayList<Double> list = new ArrayList<>();
        int count = 0;

        while (true) {
            try {

                list.add(Double.parseDouble(scan.nextLine()));

            } catch (NumberFormatException e) {

                Thread.sleep(100);
                ListIterator listerator = list.listIterator(list.size());
                while (listerator.hasPrevious()) {
                    System.out.print(listerator.previous() + " ");
                }
                count++;

                if (count > 4) {
                    throw e;
                }
            }

        }

    }
}
