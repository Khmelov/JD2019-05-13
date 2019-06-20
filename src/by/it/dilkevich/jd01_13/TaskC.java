package by.it.dilkevich.jd01_13;

import java.util.*;

public class TaskC {

    public static void main(String[] args) throws InterruptedException, NumberFormatException {

        Scanner scanner = new Scanner(System.in);
            TaskC.readData(scanner);

    }

    static void readData(Scanner sc) throws InterruptedException, NumberFormatException {

        List<Integer> numbers = new LinkedList<>();

        int countExepcions = 0;

        while (true) {
            try {


                int inputNumer = sc.nextInt();


                numbers.add(inputNumer);

            } catch (NumberFormatException | InputMismatchException e) {

                Thread.sleep(100);
                countExepcions++;
                StringBuilder sb = new StringBuilder();

                if(countExepcions > 5){
                    throw new NumberFormatException();
                }

                if (numbers.size() > 0) {

                    String del = "";
                    for (int i = 0; i < numbers.size(); i++) {

                        sb.append(del).append((double)numbers.get(numbers.size() - i - 1));
                        del = " ";
                    }
                    System.out.println(sb);
                    sb.setLength(0);
                    String x = sc.nextLine();
                }
            }
        }

    }
}
