package by.it.tbabich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 0; i < 4096; i++) {
            arrayList.add("Тимур" + i);
        }
        System.out.println(process(arrayList));

        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 0; i < 4096; i++) {
            linkedList.add("Валера" + i);
        }
        System.out.println(process(linkedList));


    }

    static String process(ArrayList<String> peoples) {
        boolean isSecond = false;
        while (peoples.size() > 1) {
            Iterator<String> iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (isSecond){
                    iterator.remove();
                }
                isSecond = !isSecond;
            }
        }
        return peoples.get(0);
    }

    static String process(LinkedList<String> peoples) {
        while (peoples.size() > 1) {
            peoples.offer(peoples.poll());
            peoples.poll();
        }
        return peoples.get(0);
    }
}
