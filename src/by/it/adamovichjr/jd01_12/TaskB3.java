package by.it.adamovichjr.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB3 {
    public static void main(String[] args) {
        ArrayList<String> array = new ArrayList<>();
        LinkedList<String> link = new LinkedList<>();
        LinkedList<String> noIterator = new LinkedList<>();
        for (int i = 1; i <= 4096; i++) {
            array.add("n" + i);
            link.add("n" + i);
            noIterator.add("n" + i);
        }
        long timer = System.nanoTime();
        System.out.printf("ArrayList: %s, время: %d\n",process(array),(System.nanoTime() - timer)/1000);
        timer = System.nanoTime();
        System.out.printf("LinkedList: %s, время: %d\n",process(link),(System.nanoTime() - timer)/1000);
        timer = System.nanoTime();
        System.out.printf("LinkedListNoIterator: %s, время: %d\n",processNoIterator(noIterator),(System.nanoTime() - timer)/1000);
        processNoIterator(link);
    }

    private static int count = 1;
    private static String process(LinkedList<String> peoples) {
        Iterator<String> it = peoples.iterator();
        while (it.hasNext() && peoples.size() != 1) {
            if (count % 2 == 0) {
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
        return peoples.get(0);
    }

    private static String process(ArrayList<String> peoples) {
        int count = 1;
        while (peoples.size() !=1) {
            for (int i = 0; i < peoples.size(); i++) {
                if (count % 2 == 0) {
                    peoples.remove(i);
                    i--;
                    count++;
                }else {
                    count++;
                }
            }
        }
        return peoples.get(0);
    }
    private static String processNoIterator(LinkedList<String> peoples){
        while (peoples.size() > 1){
            peoples.offer(peoples.poll());
            peoples.poll();
        }
        return peoples.get(0);
    }
}