package by.it.maniuk.jd01_13;

import java.io.*;

import java.util.*;

public class TaskC {
    public static void main(String[] args) throws Exception {
       // Scanner scanner = new Scanner(System.in);

        readeData();

    }

    static void readeData() throws Exception {
        List<Double> list = new ArrayList<>();
        int count = 0;
        while (count != 5) {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
               for (; ;) {
                   String vvod = reader.readLine();
                   String[] tok = vvod.split(" ");
                   for (String value : tok) {
                       double s = Double.parseDouble(value);
                       list.add(s);
                   }
               }
            } catch (Exception exe) {
                count++;
                Thread.sleep(100);
                for (int i = list.size() - 1; i >= 0; i--) {
                    System.out.print(list.get(i) + " ");
                }


            }
        }

        throw new Exception();

    }
}





