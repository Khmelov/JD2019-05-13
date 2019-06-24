package by.it.yaskevich.jd01_13;

import java.util.LinkedList;
import java.util.Scanner;

public class TaskC {
    public static void main(String[] args) throws InterruptedException {
        readData();
    }

    private static void readData() throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        int exceptinCount = 0;
        LinkedList<Double> numbers = new LinkedList<>();
        while (true) {
            try {
                numbers.push(Double.parseDouble(scanner.nextLine()));
            }
            catch (NumberFormatException e) {
                Thread.sleep(100);

                for (Double number : numbers) {
                    System.out.print(number + " ");
                }
                System.out.println();

                if (++exceptinCount == 5){
                    throw e;
                }
            }
        }
    }
}
