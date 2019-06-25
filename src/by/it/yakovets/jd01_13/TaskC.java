package by.it.yakovets.jd01_13;


import java.util.*;

public class TaskC {
    public static void main(String[] args) throws NumberFormatException, InterruptedException {
        readData();
    }

    static void readData() throws NumberFormatException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        List<Double> list = new ArrayList<>();
        int count = 0;
        while (true) {
            try {
                double expression = Double.parseDouble(sc.nextLine());
                list.add(expression);
            } catch (NumberFormatException e) {
                count++;
                if (count <= 5) {
                    Thread.sleep(100);
                    for (int i = list.size() - 1; i >= 0; i--) {
                        System.out.print(list.get(i) + " ");
                    }

                    System.out.println();

                } else throw e;
            }
        }

    }
}




