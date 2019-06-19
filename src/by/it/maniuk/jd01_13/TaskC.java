package by.it.maniuk.jd01_13;

import java.io.*;

import java.util.*;

public class TaskC {
    private static Scanner reader;

    public static void main(String[] args) throws Exception {
        reader = new Scanner(System.in);

        readData();

    }

    static void readData() throws Exception {

        List<Double> list = new ArrayList<>();
        int count = 0;
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (; ; ) {
            try {

                list.add(Double.parseDouble(reader.nextLine()));

            } catch (Exception exe) {

                Thread.sleep(100);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }
                System.out.println();
                count++;
                if (count == 5) throw exe;
            }

        }

    }
}






