package by.it.adamovichjr.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> link = new LinkedList<>();
        for (int i = 1; i <= 4096; i++) {
            array.add("n" + i);
            link.add("n" + i);
        }
        System.out.println(process(link));
        System.out.println(process(array));
    }

    static int count = 1;

    private static String process(LinkedList<String> peoples) {
        Iterator<String> it = peoples.iterator();
        while (it.hasNext() && peoples.size() != 1) {
            if (TaskB2.count % 2 == 0) {
                it.next();
                it.remove();
                count++;
            } else {
                it.next();
                count++;
            }
            if (!it.hasNext()) {
                process(peoples);
            }
        }
        TaskB2.count = 1;
        return peoples.get(0);
    }

   private static String process(ArrayList<String> peoples) {
        while (peoples.size() !=1) {
            for (int i = 0; i < peoples.size(); i++) {
                if (TaskB2.count % 2 == 0) {
                    peoples.remove(i);
                    i--;
                    count++;
                }else {
                    count++;
                }
            }
        }
        count =1;
        return peoples.get(0);
    }

}
