package by.it.dilkevich.jd01_13;

import java.util.*;

public class TaskC {

    public static void main(String[] args) throws NumberFormatException, InterruptedException {


            TaskC.readData();

    }

    static void readData() throws NumberFormatException, InterruptedException {

        Scanner sc = new Scanner(System.in);
        List<Integer> numbers = new LinkedList<>();

        int countExepcions = 0;

        while (true) {
            try {

                int inputNumer = sc.nextInt();
                numbers.add(inputNumer);

            } catch (NumberFormatException | InputMismatchException e) {

                if(countExepcions > 4){
                    throw e;
                }

                Thread.sleep(100);
                ++countExepcions;

                StringBuilder sb = new StringBuilder();

                if (numbers.size() > 0) {

                    String del = "";

                    for (int i = 0; i < numbers.size(); i++) {

                        sb.append(del).append((double)numbers.get(numbers.size() - i - 1));
                        del = " ";
                    }
                    System.out.println(sb.toString());
                    sb.setLength(0);
                    String x = sc.nextLine();
                }
            }
        }

    }
}
