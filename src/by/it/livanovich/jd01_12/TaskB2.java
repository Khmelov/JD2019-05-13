package by.it.livanovich.jd01_12;

import java.util.*;

public class TaskB2 {
    static String process(ArrayList<String> peoples) {
    boolean check=true;
       do {
           Iterator <String> iterator=peoples.listIterator();
           if (check) {
               while (iterator.hasNext()) {
                   iterator.next();
                   if (iterator.hasNext()) {
                       iterator.next();
                       iterator.remove();
                   }
                   else check=false;
               }
           }
           else {
               while (iterator.hasNext()) {
                   iterator.next();
                   iterator.remove();
                   if (iterator.hasNext()) {
                       iterator.next();
                   }
                   else check=true;
               }
           }
       }
       while (peoples.size()>1);
        return peoples.get(0);
    }
        static String process (LinkedList <String> peoples){
            if (peoples.size()%2==0); boolean check=true;
            do {
                Iterator <String> iterator=peoples.listIterator();
                if (check) {
                    while (iterator.hasNext()) {
                        iterator.next();
                        if (iterator.hasNext()) {
                            iterator.next();
                            iterator.remove();
                        }
                        else check=false;
                    }
                }
                else {
                    while (iterator.hasNext()) {
                        iterator.next();
                        iterator.remove();
                        if (iterator.hasNext()) {
                            iterator.next();
                        }
                        else check=true;
                    }
                }
            }
            while (peoples.size()>1);
            return peoples.get(0);
        }

    public static void main(String[] args) {
        List <String> arraylist=new ArrayList<>();
        List <String> linkedlist=new LinkedList<>();
        Scanner sc=new Scanner(System.in);
        String name;
        while (!(name=sc.next()).equals("end")){
            arraylist.add(name);
            linkedlist.add(name);
        }
        System.out.println(process((ArrayList<String>) arraylist));
        System.out.println(process((LinkedList<String>) linkedlist));
    }
}
