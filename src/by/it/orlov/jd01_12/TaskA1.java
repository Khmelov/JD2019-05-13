package by.it.orlov.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TaskA1 {

    static Random generator = new Random(15);
    private List<Integer> grades = new ArrayList<>();

    private void clearBad(List<Integer> grades) {
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < 4)
                iterator.remove();

        }
    }

    public static void main(String[] args) {
        TaskA1 instance = new TaskA1();
        for (int i = 0; i < 25; i++)
            instance.grades.add(1 + generator.nextInt(10));
        System.out.println(instance.grades);
        instance.clearBad(instance.grades);
        System.out.println(instance.grades);

    }


}

