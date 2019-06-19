package by.it.adamovichjr.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private List<Integer>list = new ArrayList<>();
    static void clearBad(List<Integer>grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            if(iterator.next()<4){
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        Random random = new Random();
        TaskA1 task = new TaskA1();
        int students = 15;
        for (int i = 0; i < students; i++) {
            task.list.add(random.nextInt(10)+1);
        }
        System.out.println(task.list);
        clearBad(task.list);
        System.out.println(task.list);
    }
}
