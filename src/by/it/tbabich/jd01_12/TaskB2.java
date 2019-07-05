package by.it.tbabich.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class TaskB2 {
    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Тимур1");
        arrayList.add("Тимур2");
        arrayList.add("Тимур3");
        System.out.println(process(arrayList));

        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("Валера1");
        linkedList.add("Валера2");
        linkedList.add("Валера3");
        linkedList.add("Валера4");
        linkedList.add("Валера5");
        linkedList.add("Валера6");
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
}
