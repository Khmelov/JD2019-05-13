package by.it.guchek.jd01_11;

import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
        List <String> mylist = new ListA<>(); //my
        List <String> list = new ArrayList<>(); //настоящий

        //проверим добавление
        mylist.add("one"); list.add("one");
        mylist.add("two"); list.add("two");
        mylist.add("four");list.add("four");
        System.out.println("mylist:"+mylist+"\n  list:"+list);
        mylist.add(2, "three"); list.add(2,"three");
        mylist.add(0, "Start"); list.add(0,"Start");
        System.out.println("mylist:"+mylist+"\n  list:"+list);

        // проверим удаление
        mylist.remove(2); list.remove(2);
        System.out.println("mylist:"+mylist+"\n  list:"+list);

        // проверим чтение
        mylist.get(3); list.get(3);
        System.out.println("mylist:"+mylist.get(3)+"\n  list:"+list.get(3));



    }

}
