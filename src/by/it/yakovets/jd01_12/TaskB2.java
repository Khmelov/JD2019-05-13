package by.it.yakovets.jd01_12;

import java.util.*;

public class TaskB2 {

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        LinkedList<String> list1 = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            list.add(i + 1 + "");
            list1.add(i + 1 + "");

        }
        System.out.println(list);
        System.out.println(list1);
        System.out.println(process(list));
        System.out.println(process(list1));

    }

    static String process(ArrayList<String> list) {
        int counter = 1;
        while (list.size() > 1) {
            Iterator<String> it = list.iterator();
            if(counter!=1){
                counter = counter - list.size();
            }
            while(it.hasNext()){
                if(list.indexOf(it.next())==counter){
                    it.remove();
                    counter++;
                }
            }

        }
//        int pos = 0;
//        while (list.size() != 1) {
//            pos = (pos + 1) % list.size();
//            list.remove(pos);
//        }
        return list.get(0);
    }

    static String process(LinkedList<String> list) {
        int counter = 1;
        while (list.size() > 1) {
            Iterator<String> it = list.iterator();
            if(counter!=1){
                counter = counter - list.size();
            }
            while(it.hasNext()){
                if(list.indexOf(it.next())==counter){
                    it.remove();
                    counter++;
                }
            }

        }

//        int pos = 0;
//        while (list.size() != 1) {
//            pos = (pos + 1) % list.size();
//            list.remove(pos);
//        }
        return list.get(0);
    }
}



