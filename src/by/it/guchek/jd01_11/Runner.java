package by.it.guchek.jd01_11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {

        List <String> mylist = new ListA<>(); //my A
        List <String> list = new ArrayList<>(); //настоящий
        List <String> mylist2 = new ListB<>();

        Set<String> set = new HashSet<>();
        Set<String> myHashset = new SetC<>();



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

        //
        mylist.add("Twelve");
        mylist.addAll(3, list);
        System.out.println(mylist);
        System.out.println("Лист добавить лист");
        list.addAll(list);
        System.out.println(list);

        mylist2.add("kkkk");
        mylist2.addAll(list);
        System.out.println("AddAll:"+mylist2);

        mylist2.addAll(5, list);
        System.out.println("AddAll index 5:"+mylist2);
        //
        System.out.println("Переписываем HashSet");
        myHashset.add("Привет");
        myHashset.add("Пока");
        myHashset.add("Как дела");
        myHashset.add("Как тебя зовут");
        myHashset.add("Как дела");
        System.out.println("add:"+myHashset);

        set.add("Привет");
        set.add("Пока");
        set.add("Как дела");
        set.add("Как тебя зовут");
        set.add("Как дела");
        System.out.println("add:"+set);




    }

}
