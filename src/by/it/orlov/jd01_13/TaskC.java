package by.it.orlov.jd01_13;


import java.util.*;

public class TaskC {
    private static Scanner scanForRead;

    public static void main(String[] args) throws Exception {
        scanForRead = new Scanner(System.in);

        readData();

    }

    static void readData() throws Exception {

        List<Double> list = new ArrayList<>();
        int count = 0;
        for (; ; ) {
            try {
                list.add(Double.parseDouble(scanForRead.nextLine()));
            } catch (Exception e) {
                Thread.sleep(100);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
                count++;
                if (count == 5) throw e;
            }

        }

    }
}






