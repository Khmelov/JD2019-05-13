package by.it.buymistrov.jd01_12;

import java.util.*;

public class TaskB3 {

    private static String process(ArrayList<String> peoples) {
        boolean del = false;
        ArrayList<String> inWork = new ArrayList<>(peoples);
        while (inWork.size() > 1) {
            Iterator iterator = inWork.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (del) {
                    iterator.remove();
                }
                del = !del;
            }
        }
        return inWork.get(0);
    }

    private static String process(LinkedList<String> peoples) {

        boolean del = false;
        while (peoples.size() > 1) {
            Iterator iterator = peoples.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (del) {
                    iterator.remove();
                }
                del = !del;
            }
        }
        return peoples.get(0);
    }

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();
        ArrayList<String> listArray = new ArrayList<>();
        int n = 4096;
        for (int i = 1; i <= n; i++) {
            String name = String.valueOf(i);
            list.add(name);
            listArray.add(name);
        }


//        System.out.println(list);

        long t = System.nanoTime();
        System.out.println(process(listArray));
        long tA = System.nanoTime() - t;

        t = System.nanoTime();
        System.out.println(process(list));
        long tL = System.nanoTime() - t;


        System.out.println(tA / 1000 + " ArrayList");
        System.out.println(tL / 1000 + " List");
    }
}
