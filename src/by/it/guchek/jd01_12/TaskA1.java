package by.it.guchek.jd01_12;

import by.it.guchek.jd01_04.TaskA;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    private List <Integer> list = new ArrayList<>();
    void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            int grade=iterator.next();
            if (grade<4)
                iterator.remove();
        }
       //grades.removeIf(i-> (i<4));  второй вариант без итератора с предикатом

    }

    public static void main(String[] args) {
        TaskA1 a1 = new TaskA1();
        for (int i = 0; i <25 ; i++) {
            a1.list.add((int) Math.ceil(Math.random() * 10));
        }
        System.out.println(a1.list);
        a1.clearBad(a1.list);
        System.out.println(a1.list);

    }

}
