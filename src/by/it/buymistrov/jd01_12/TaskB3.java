package by.it.buymistrov.jd01_12;

import java.util.*;

public class TaskB3 {

    private static String process(ArrayList<String> peoples) {
        boolean del = false;
        ArrayList<String> inWork = new ArrayList<>(peoples);
        while (inWork.size() > 1) {
            for (int i = 0; i < inWork.size(); i++) {
                if (del) {
                    inWork.remove(i--);
                }
                del = !del;
            }
        }
        return inWork.get(0);
    }

    private static String process(LinkedList<String> peoples) {
        String out = peoples.get(0);
        while (peoples.size() > 1) {
            Iterator iterator = peoples.iterator();
            for (int i = 0; iterator.hasNext(); i++, iterator.next()) {
                if (i % 2 == 1) {
                    i = 0;
                    iterator.remove();
                }
            }
        }
        return out ;
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
        System.out.println(list);

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
