package by.it.adamovichjr.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String line;
        while (!(line = sc.nextLine()).equals("END")) {
            listString.addFirst(line);
            readData();
        }
    }

    private static LinkedList<String> listString = new LinkedList<>();

    private static LinkedList<Double> listDouble = new LinkedList<>();

    private static int countException = 0;

    private static void readData() throws InterruptedException {

        try {
            listDouble.addFirst(Double.valueOf(listString.getFirst()));
        } catch (NumberFormatException e) {
            if (countException == 5) {
                throw e;
            }
            Thread.sleep(100);
            for (Double element : listDouble) {
                System.out.print(element + " ");
            }
            System.out.println();
            countException++;
        }
    }
}
