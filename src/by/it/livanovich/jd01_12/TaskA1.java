package by.it.livanovich.jd01_12;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {
    private List<Integer> list = new ArrayList<>();

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            int grade = iterator.next();
            if (grade < 4) {
                iterator.remove();
            }
        }
    }

    public static void main(String[] args) {
        TaskA1 task = new TaskA1();
        Random gen = new Random();
        for (int i = 0; i < 35; i++)
            task.list.add(gen.nextInt(10) + 1);
        System.out.println(task.list);
        task.clearBad(task.list);
        System.out.println(task.list);
    }
}
