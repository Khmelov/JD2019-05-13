package by.it.guchek.jd01_12;

import java.util.*;

public class TaskB1 {

    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>() {};
        List<String> arrayStr = new ArrayList<String>();
        Scanner scan = new Scanner(System.in);
        //StringBuilder sb = new StringBuilder();
        String stroke;

        while (!(stroke = scan.next()).equals("end")) {
            String stroke1 = stroke.replaceAll("[\\s:;.,-]+", "");
            arrayStr.add(stroke1);
            //System.out.println(stroke);
        }
        int count = 0;

        ListIterator<String> iteratorStr = arrayStr.listIterator();
        while (iteratorStr.hasNext()) {
            String next = iteratorStr.next();
            if (next.equals("isn't")) {
                iteratorStr.set("don’t");
            }
        }

        for (int j = 0; j < arrayStr.size(); j++) {

            for (int k = 0; k < arrayStr.size(); k++) {

                if ((arrayStr.get(j)).equals((arrayStr.get(k))))
                    count = count + 1;
            }
            hm.put(arrayStr.get(j), count);


            count = 0;
        }

        System.out.println(arrayStr);
        System.out.println(hm);
    }
}
