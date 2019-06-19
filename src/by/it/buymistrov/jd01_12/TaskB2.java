package by.it.buymistrov.jd01_12;

import java.util.*;


public class TaskB2 {


    static String process(ArrayList<String> peoples) {
        boolean del = false;
        while (peoples.size() > 1) {
            for (int i = 0; i<peoples.size(); i++) {
                if (del) {
                    peoples.remove(i--);
                }
                del = !del;
            }
        }
        return peoples.get(0);
    }


    static String process(LinkedList<String> peoples) {
        boolean del = false;
        while (peoples.size() > 1) {
            for (int i = 0; i<peoples.size(); i++) {
                if (del) {
                    peoples.remove(i--);
                }
                del = !del;
            }
        }
        return peoples.get(0);
    }


    public static void main(String[] args) {


        LinkedList<String> list = new LinkedList<>();
        ArrayList<String> listArray = new ArrayList<>();

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            String name = sc.next();
            list.add(name);
            listArray.add(name);
        }

        System.out.println(list);

        System.out.println(process(list));
        System.out.println(process(listArray));



    }
}
