package by.it.tbabich.jd01_13;

import java.util.*;

public class TaskC {

    private static LinkedList<String> stringList = new LinkedList<>();
    private static LinkedList<Double> doubleList = new LinkedList<>();
    private static int expressions = 0;

    public static void main(String[] args) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        String inputLine;
        while (!(inputLine = sc.nextLine()).equals("END")) {
            stringList.addFirst(inputLine);
            readData();
        }
    }

    private static void readData() throws InterruptedException {
        try {
            doubleList.addFirst(Double.valueOf(stringList.getFirst()));
        } catch (NumberFormatException e) {
            if (expressions == 5) throw e;
            Thread.sleep(100);
            for (Double element : doubleList) {
                System.out.print(element + " ");
            }
            System.out.print("\n");
            expressions++;
        }
    }
}
